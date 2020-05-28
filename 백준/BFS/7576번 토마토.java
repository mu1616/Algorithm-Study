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
		int m = scan.nextInt();
		int n = scan.nextInt();
		array = new int[n][m];
		visited = new int[n][m];
		dist = new int[n][m];
		for(int i=0; i< n; i++) {
			for(int j=0; j< m; j++) {
				array[i][j] = scan.nextInt();
			}
		}
		bfs();
		int max = 0;
		for(int i=0; i< dist.length; i++) {
			for(int j=0; j< dist[0].length; j++) {
				if(max < dist[i][j]) max = dist[i][j];
			}
		}
		boolean complete = true;
		for(int i=0; i< array.length; i++) {
			for(int j=0; j< array[0].length; j++) {
				if(array[i][j]==0) complete = false;
			}
		}
		int result = (complete==true)?max:-1;
		System.out.println(result);
	}
	
	public void bfs() {
		Queue<Node> queue = new LinkedList<>();
		for(int i=0; i< array.length; i++) {
			for(int j=0; j< array[0].length; j++) {
				if(array[i][j]==1) {
					Node node = new Node(i,j);
					queue.offer(node);
					dist[i][j] = 0;
					visited[i][j] = 1;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			if(curr.row-1 >=0 && array[curr.row-1][curr.col] == 0 && visited[curr.row-1][curr.col] == 0) {
				visited[curr.row-1][curr.col] = 1;
				array[curr.row-1][curr.col] = 1;
				dist[curr.row-1][curr.col] = dist[curr.row][curr.col] + 1;
				queue.offer(new Node(curr.row-1, curr.col));
			}
			if(curr.row+1 < array.length && array[curr.row+1][curr.col] == 0 && visited[curr.row+1][curr.col] == 0) {
				visited[curr.row+1][curr.col] = 1;
				array[curr.row+1][curr.col] = 1;
				dist[curr.row+1][curr.col] = dist[curr.row][curr.col] + 1;
				queue.offer(new Node(curr.row+1, curr.col));
			}
			if(curr.col-1 >=0 && array[curr.row][curr.col-1] == 0 && visited[curr.row][curr.col-1] == 0) {
				visited[curr.row][curr.col-1] = 1;
				array[curr.row][curr.col-1] = 1;
				dist[curr.row][curr.col-1] = dist[curr.row][curr.col] + 1;
				queue.offer(new Node(curr.row, curr.col-1));
			}
			if(curr.col+1 < array[0].length && array[curr.row][curr.col+1] == 0 && visited[curr.row][curr.col+1] == 0) {
				visited[curr.row][curr.col+1] = 1;
				array[curr.row][curr.col+1] = 1;
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