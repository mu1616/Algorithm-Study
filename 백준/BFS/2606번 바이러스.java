import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int graph[][];
	boolean visited[];
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int k = scan.nextInt();
		graph = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		
		for (int i = 0; i < k; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		
		System.out.println(bfs());
	}

	public int bfs() {
		int result = 0;
		Queue<Integer> queue = new LinkedList<>();
		visited[1] = true;
		queue.offer(1);
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			for(int i = 0; i < graph.length; i++) {
				if(graph[curr][i] == 1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
					result++;
				}
			}
		}
		
		return result;
	}

}