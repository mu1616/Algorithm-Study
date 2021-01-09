import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int dx[] = {-1, 1, 0, 0};
	int dy[] = {0, 0, -1, 1};
	char graph[][];
	int maxDist;
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int rowSize = scan.nextInt();
		int columnSize = scan.nextInt();
		graph = new char[rowSize][columnSize];

		for (int i = 0; i < rowSize; i++) {
			String str = scan.next();
			for (int j = 0; j < columnSize; j++) {
				graph[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				if (graph[i][j] == 'L')
					bfs(j, i);
			}
		}
		
		System.out.println(maxDist);
	}
	
	public void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, y));
		boolean visited[][] = new boolean[graph.length][graph[0].length];
		visited[y][x] = true;
		int dist[][] = new int[graph.length][graph[0].length];
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				
				if (nx >= 0 && nx < graph[0].length && ny >= 0 && ny < graph.length) {
					if (graph[ny][nx] == 'L' && !visited[ny][nx]) {
						queue.offer(new Node(nx, ny));
						visited[ny][nx] = true;
						dist[ny][nx] = dist[curr.y][curr.x] + 1;
						maxDist = Math.max(dist[ny][nx], maxDist);
					}
				}
			}
		}
	}
	
	class Node {
		int x;
		int y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
