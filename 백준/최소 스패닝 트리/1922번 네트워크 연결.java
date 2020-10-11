import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int parent[];
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int V = scan.nextInt();
		int E = scan.nextInt();
		parent = new int[V + 1];
		for(int i = 0; i < V; i++) parent[i] = i;
		Edge edges[] = new Edge[E];
		for(int i = 0; i < E; i++) edges[i] = new Edge(scan.nextInt(), scan.nextInt(), scan.nextInt());
		
		Arrays.sort(edges, (e1, e2) -> {
			return e1.cost - e2.cost;
		});
		
		int sumCost = 0;
		int selectCnt = 0;

		for(int i = 0; i < edges.length; i++) {
			int u = edges[i].u;
			int v = edges[i].v;
			
			if(find(u) == find(v)) continue;
			
			union(u, v);
			
			sumCost += edges[i].cost;
			if(++selectCnt >= V - 1) break;
		}
		
		System.out.println(sumCost);
	}
	
	public int find(int x) {
		if(parent[x] == x) {
			return x;
		} else {
			return find(parent[x]);
		}
	}
	
	public void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y)
			parent[y] = x;
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