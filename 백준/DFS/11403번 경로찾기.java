import java.io.*;
import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int n;
	int array[][];
	int result[][];
	boolean visited[];
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.solution();

	}

	public void solution() {
		n = scan.nextInt();
		array = new int[n][n];
		result = new int[n][n];
		visited = new boolean[n];
		for(int i=0; i< n; i++) {
			for(int j=0; j< n; j++) {
				array[i][j] = scan.nextInt();
				result[i][j] = array[i][j];
			}
		}
		for(int i=0; i< n; i++) {
			for(int j=0; j< n; j++) {
				for(int k=0; k< n; k++)
					visited[k] = false;
				dfs(i, i, j, 0);
			}
		}
		
		for(int i=0; i< n; i++) {
			for(int j=0; j< n; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void dfs(int start, int node, int dest, int cnt) {
		if(cnt > 0)
			visited[node] = true;
		
		if(node==dest && cnt >0)
			result[start][dest] = 1;
		
		for(int next=0; next< n; next++) {
			if(!visited[next] && array[node][next]== 1) {
				dfs(start, next, dest, cnt+1);
			}
		}
	}
	

	
}
