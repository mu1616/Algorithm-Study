import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int dx[] = {-2, -2, -1, -1, 1, 1, 2, 2};
	int dy[] = {-1, 1, -2, 2, -2, 2, -1, 1};
	boolean visited[][];
	int dist[][];
	int chess[][];
	int x2;
	int y2;
	public static void main(String[] args) {
		Main main = new Main();
		int n = scan.nextInt();
		for(int i=0; i< n; i++)
			main.solution();
	}

	public void solution() {
		int m = scan.nextInt();
		chess = new int[m][m];
		visited = new boolean[m][m];
		dist = new int[m][m];
		int y1 = scan.nextInt();
		int x1 = scan.nextInt();
		y2 = scan.nextInt();
		x2 = scan.nextInt();
		
		bfs(x1, y1);
		System.out.println(dist[y2][x2]);
	}
	
	public void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		visited[y][x] = true;
		dist[y][x] = 0;
		queue.offer(new Node(x,y));
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			
			for(int i=0; i< 8; i++) {
				int cx = curr.x + dx[i];
				int cy = curr.y + dy[i];
				if(cx >=0 && cx < chess[0].length && cy >=0 && cy < chess.length) {
					if(!visited[cy][cx]) {
						queue.offer(new Node(cx, cy));
						visited[cy][cx] = true;
						dist[cy][cx] = dist[curr.y][curr.x] + 1; 
					}
				}
			}
		}
	}
	
	class Node {
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}