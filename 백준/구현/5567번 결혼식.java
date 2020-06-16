import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int array[][];
	int result;
	int dist[];
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int m = scan.nextInt();
		array = new int[n+1][n+1];
		
		for(int i=0; i< m; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			array[a][b] = 1;
			array[b][a] = 1;
		}
		
		boolean visited[] = new boolean[n+1];
		dist = new int[n+1];
		
		dfs(1, visited);
		
		for(int i=1; i< dist.length; i++) {
			if(dist[i]==1 || dist[i]==2)
				result++;
		}
		System.out.print(result);
	}
	
	public void dfs(int node, boolean visited[]) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(node);
		visited[node] = true;
		dist[node] = 0;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			for(int i=1; i< visited.length; i++) {
				if(!visited[i] && array[curr][i] == 1) {
					queue.offer(i);
					dist[i] = dist[curr] + 1;
					visited[i] = true;
				}
			}
		}
	}
	

	
	
}