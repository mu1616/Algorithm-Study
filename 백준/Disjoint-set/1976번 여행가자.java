import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int graph[][];
	int parent[];
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int m = scan.nextInt();
		int dstArr[] = new int[m];
		parent = new int[n];
		graph = new int[n][n];
		for(int i = 0; i < n ; i++) {
			for(int j = 0; j < n; j++) {
				graph[i][j] = scan.nextInt();
			}
		}
		for(int i = 0; i < m; i++) dstArr[i] = scan.nextInt() - 1;
		for(int i = 0; i < n; i++) parent[i] = i;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(graph[i][j] == 1) {
					union(i, j);
				}
			}
		}
		
		boolean possible = true;
		for(int i = 0; i < m - 1; i++) {
			if(find(dstArr[i]) != find(dstArr[i + 1])) {
				possible = false;
				break;
			}
		}
		
		if(possible) System.out.println("YES");
		else System.out.println("NO");
	}
	
	public int find(int u) {
		if(u == parent[u]) {
			return u;
		}
		
		return find(parent[u]);
	}
	
	public void union(int u, int v) {
		u = find(u);
		v = find(v);
		
		if(u != v) parent[v] = u;
	}
}