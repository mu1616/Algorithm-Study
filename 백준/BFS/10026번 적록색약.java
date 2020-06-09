import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int visited[][];
	int array[][];
	int dx[] = {-1, 1, 0, 0};
	int dy[] = {0, 0, -1, 1};
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		array = new int[n][n];
		visited = new int[n][n];
		for(int i=0; i< n; i++) {
			String str = scan.next();
			for(int j=0; j< n; j++) {
				String a = str.substring(j, j+1);
				if(a.equals("R"))
					array[i][j] = 1;
				if(a.equals("G"))
					array[i][j] = 2;
				if(a.equals("B"))
					array[i][j] = 3;
			}
		}

		int result1 = 0;
		for(int i=0; i< n; i++) {
			for(int j=0; j< n; j++) {
				if(visited[i][j] == 0) {
					bfs(i,j);
					result1++;
				}
			}
		}
		
		for(int i=0; i< n; i++) {
			for(int j=0; j< n; j++) {
				visited[i][j] = 0;
				if(array[i][j] == 1) 
					array[i][j] = 2;
			}
		}
		
		int result2 = 0;
		for(int i=0; i< n; i++) {
			for(int j=0; j< n; j++) {
				if(visited[i][j] == 0) {
					bfs(i,j);
					result2++;
				}
			}
		}
		System.out.println(result1+" "+result2);
	}
	
	public int bfs(int row, int col) {
		int cnt = 1;
		Queue<Node> queue = new LinkedList<>();
		visited[row][col] = 1;
		queue.offer(new Node(row, col));
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			
			for(int i=0; i< 4; i++) {
				if(curr.row + dy[i] >=0 && curr.row + dy[i] < array.length && 
						curr.col + dx[i] >=0 && curr.col + dx[i] < array[0].length) {
					if(array[curr.row+dy[i]][curr.col+dx[i]] == array[curr.row][curr.col] && visited[curr.row+dy[i]][curr.col+dx[i]] == 0) {
						visited[curr.row+dy[i]][curr.col+dx[i]] = 1;
						cnt++;
						queue.offer(new Node(curr.row+dy[i], curr.col+dx[i]));
					}
				}
			}
		}
		return cnt;
	}
	
	
	
	public void printArray(int array[][]) {
		for(int i=0; i< array.length; i++) {
			for(int j=0; j< array[0].length; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	class Node {
		int row;
		int col;
		Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
