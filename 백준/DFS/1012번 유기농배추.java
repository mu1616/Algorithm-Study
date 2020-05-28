import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int visited[][];
	int array[][];
	Stack<P> stack = new Stack<>();
	public static void main(String[] args) {
		Main m = new Main();
		int t = scan.nextInt();
		for(int i=0; i< t; i++)
			m.solution();
	}

	public void solution() {
		int m = scan.nextInt();
		int n = scan.nextInt();
		int k = scan.nextInt();
		array = new int[n][m];
		visited = new int[n][m];
		for(int i=0; i< k; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			array[y][x] = 1;
		}
		int sum = 0;
		for(int i=0; i< array.length; i++) {
			for(int j=0; j< array[0].length; j++) {
				if(array[i][j] == 1) {
					sum = sum + dfs(i,j);
				}
			}
		}
		System.out.println(sum);
	}
	
	public int dfs(int row, int col) {
		P p = new P(row,col);
		stack.push(p);
		int result = 0;
		while(!stack.isEmpty()) {
			P curr = stack.pop();
			if(visited[curr.row][curr.col] == 0) {
				visited[curr.row][curr.col] = 1;
				result = 1;
			}	
			if(curr.row-1 >=0 && array[curr.row-1][curr.col] == 1 && visited[curr.row-1][curr.col] == 0) 
				stack.push(new P(curr.row-1, curr.col));
			if(curr.row+1 < array.length && array[curr.row+1][curr.col] == 1 && visited[curr.row+1][curr.col] == 0) 
				stack.push(new P(curr.row+1, curr.col));
			if(curr.col-1 >=0 && array[curr.row][curr.col-1] == 1 && visited[curr.row][curr.col-1] == 0)
				stack.push(new P(curr.row, curr.col-1));
			if(curr.col+1 < array[0].length && array[curr.row][curr.col+1] == 1 && visited[curr.row][curr.col+1] == 0)
				stack.push(new P(curr.row, curr.col+1));
		}
		return result;
	}

	public void printArray(int array[][]) {
		for(int i=0; i< array.length; i++) {
			for(int j=0; j< array[0].length; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	class P {
		int col;
		int row;
		P(int row, int col) {
			this.row = row;
			this.col = col;		
		}
	}

}