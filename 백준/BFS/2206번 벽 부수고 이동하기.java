import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int dx[] = {-1, 1, 0, 0};
	int dy[] = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int m = scan.nextInt();
		int map[][] = new int[n][m];
		for(int i = 0; i < n; i++) {
			String str = scan.next();
			for(int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		int answer = bfs(map);
		System.out.println(answer);
	}
	
	public int bfs(int map[][]) {
		int min = Integer.MAX_VALUE;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(0, 0));
		boolean visited[][][] = new boolean[map.length][map[0].length][2];
		visited[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			if(curr.x == map[0].length - 1 && curr.y == map.length -1 ) {
				if(curr.depth < min) min = curr.depth;
				continue;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				
				if(nx >= 0 && nx < map[0].length && ny >= 0 && ny < map.length) {
					if(map[ny][nx] == 0) {
						if(curr.crash && !visited[ny][nx][1]) {
							visited[ny][nx][1] = true;
						} else if(!curr.crash && !visited[ny][nx][0]) {
							visited[ny][nx][0] = true;
						} else {
							continue;
						}
						Node node = new Node(nx, ny);
						node.depth = curr.depth + 1;
						node.crash = curr.crash;
						queue.offer(node);
					}
				
					
					if(!visited[ny][nx][0] && map[ny][nx] == 1 && !curr.crash) {
						visited[ny][nx][0] = true;
						Node node = new Node(nx, ny);
						node.depth = curr.depth + 1;
						node.crash = true;
						queue.offer(node);
					}
				}
			}
		}
		
		return (min == Integer.MAX_VALUE) ? -1 : min;
	}
	
	class Node {
		boolean crash;
		int x;
		int y;
		int depth = 1;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}