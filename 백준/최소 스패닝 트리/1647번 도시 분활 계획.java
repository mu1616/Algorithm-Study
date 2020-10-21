import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int parent[];
	int rank[];
	Edge edges[];
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int m = scan.nextInt();
		edges = new Edge[m];
		parent = new int[n + 1];
		rank = new int[n + 1];
		for(int i = 0; i < m; i++) {
			edges[i] = new Edge(scan.nextInt(), scan.nextInt(), scan.nextInt());
		}
		
		int sum = kruskal(n);
		System.out.println(sum);
	}
	
	public int kruskal(int n) {
		Arrays.sort(edges, (edge1, edge2) -> {
			return edge1.cost - edge2.cost;
		});
		
		for(int i = 0; i < n; i++) parent[i] = i;
		
		int sumCost = 0;
		int selectCnt = 0;
		for(int i = 0; i < edges.length; i++) {
			int u = edges[i].u;
			int v = edges[i].v;
			
			if(find(u) == find(v)) continue;
			
			union(u, v);
			sumCost += edges[i].cost;
			if(++selectCnt >= n - 2) break;
		}
		
		return sumCost;
	}
	
	public void union(int u, int v) {
		u = find(u);
		v = find(v);
		
		if(u == v) return;
		
		if(rank[u] > rank[v]) {
			int tmp = u;
			u = v;
			v = tmp;
		}
		
		parent[u] = v;
		if(rank[u] == rank[v]) rank[v]++;
	}
	
	public int find(int u) {
		if(u == parent[u])
			return u;
		
		return parent[u] = find(parent[u]);
	}
	
	class Edge {
		int u;
		int v;
		int cost;
		Edge(int u, int v, int cost) {
			this.u = u;
			this.v = v;
			this.cost = cost;
		}
	}
}