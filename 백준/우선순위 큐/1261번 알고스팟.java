import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int dx[] = {-1, 1, 0, 0};
	int dy[] = {0, 0, -1, 1};
	int graph[][];
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int m = scan.nextInt();
		int n = scan.nextInt();
		graph = new int[n][m];
		for(int i = 0; i < n; i++) {
			String str = scan.next();
			for(int j = 0; j < m; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs();
	}
	
	public void bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
			if(n1.crash == n2.crash) return n2.dist - n1.dist;
			return n1.crash - n2.crash;
		});
		pq.offer(new Node(0, 0, 0, 0));
		boolean visited[][] = new boolean[graph.length][graph[0].length];
		visited[0][0] = true;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();

			if(curr.x == graph[0].length - 1 && curr.y == graph.length - 1) {
				System.out.println(curr.crash);
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				
				if(nx >= 0 && nx < graph[0].length && ny >= 0 && ny < graph.length) {
					if(!visited[ny][nx] && graph[ny][nx] == 0) {
						pq.offer(new Node(nx, ny, curr.dist + 1, curr.crash));
						visited[ny][nx] = true;
					}
					
					if(!visited[ny][nx] && graph[ny][nx] == 1) {
						pq.offer(new Node(nx, ny, curr.dist + 1, curr.crash + 1));
						visited[ny][nx] = true;
					}
				}
			}
		}
	}
	
	
	class Node {
		int x;
		int y;
		int dist;
		int crash;
		Node(int x, int y, int dist, int crash) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.crash = crash;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", dist=" + dist + ", crash=" + crash + "]";
		}
		
	}
}
