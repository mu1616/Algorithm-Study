import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int array[][];
	int visited[][];
	int dist[][];
	public static void main(String[] args) {
		Main m = new Main();
		m.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int m = scan.nextInt();
		array = new int[n][m];
		visited = new int[n][m];
		dist = new int[n][m];
		for(int i=0; i< n; i++) {
			String input = scan.next();
			for(int j=0; j< m; j++) {
				array[i][j] = input.charAt(j)-'0';
			}
		}
		bfs();
		System.out.println(dist[n-1][m-1]+1);
	}
	
	public void bfs() {
		Queue<Node> queue = new LinkedList<>();
		Node node = new Node(0,0);
		queue.offer(node);
		dist[0][0] = 0;
		visited[0][0] = 1;
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			if(curr.row-1 >=0 && array[curr.row-1][curr.col] == 1 && visited[curr.row-1][curr.col] == 0) {
				visited[curr.row-1][curr.col] = 1;
				dist[curr.row-1][curr.col] = dist[curr.row][curr.col] + 1;
				queue.offer(new Node(curr.row-1, curr.col));
			}
			if(curr.row+1 < array.length && array[curr.row+1][curr.col] == 1 && visited[curr.row+1][curr.col] == 0) {
				visited[curr.row+1][curr.col] = 1;
				dist[curr.row+1][curr.col] = dist[curr.row][curr.col] + 1;
				queue.offer(new Node(curr.row+1, curr.col));
			}
			if(curr.col-1 >=0 && array[curr.row][curr.col-1] == 1 && visited[curr.row][curr.col-1] == 0) {
				visited[curr.row][curr.col-1] = 1;
				dist[curr.row][curr.col-1] = dist[curr.row][curr.col] + 1;
				queue.offer(new Node(curr.row, curr.col-1));
			}
			if(curr.col+1 < array[0].length && array[curr.row][curr.col+1] == 1 && visited[curr.row][curr.col+1] == 0) {
				visited[curr.row][curr.col+1] = 1;
				dist[curr.row][curr.col+1] = dist[curr.row][curr.col] + 1;
				queue.offer(new Node(curr.row, curr.col+1));
			}
		}
	}
	
	class Node {
		int col;
		int row;
		Node(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	

}