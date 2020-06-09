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
		int m = scan.nextInt();
		int n = scan.nextInt();
		array = new int[m][n];
		visited = new int[m][n];
		int l = scan.nextInt();
		for(int i=0; i< l; i++) {
			int x1 = scan.nextInt();
			int y1 = scan.nextInt();
			int x2 = scan.nextInt();
			int y2 = scan.nextInt();
			for(int j=m-y1-1 ; j >= m-y2; j--) {
				for(int k=x1; k<= x2-1; k++) {
					array[j][k] = 1;
				}
			}
		}
		
		ArrayList<Integer> resultList = new ArrayList<>();
		for(int i=0; i< m; i++) {
			for(int j=0; j< n; j++) {
				if(array[i][j] == 0 && visited[i][j] == 0) {
					resultList.add(bfs(i,j));
				}
			}
		}
		
		Collections.sort(resultList);
		
		System.out.println(resultList.size());
		for(int i : resultList)
			System.out.print(i+" ");
		//printArray(array);
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
					if(array[curr.row+dy[i]][curr.col+dx[i]] == 0 && visited[curr.row+dy[i]][curr.col+dx[i]] == 0) {
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
