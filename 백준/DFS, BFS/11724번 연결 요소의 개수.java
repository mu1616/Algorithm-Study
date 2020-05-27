import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int visited[];
	int graph[][];
	int n;
	public static void main(String[] args) {
		Main m = new Main();
		m.solution();
	}

	public void solution() {
		n = scan.nextInt();
		int m = scan.nextInt();
		visited = new int[n];
		graph = new int[n][n];
		for(int i=0; i< m; i++) {
			int a = scan.nextInt()-1;
			int b = scan.nextInt()-1;
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		int cnt = 0;
		for(int i=0; i< n; i++) {
			if(visited[i]==0) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	public void dfs(int node) {
		visited[node] = 1;
		for(int next = 0; next< n; next++) {
			if(visited[next]==0 && graph[node][next]==1)
				dfs(next);
		}
	}

	public void printArray(int array[][]) {
		for(int i=0; i< array.length; i++) {
			for(int j=0; j< array[0].length; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	


}