import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int visited[][];
	public static void main(String[] args) {
		Main m = new Main();
		m.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int m = scan.nextInt();
		int array[][] = new int[n][m];
		visited = new int[n][m];
		for(int i=0; i< n; i++) {
			for(int j=0; j< m; j++) {
				array[i][j] = scan.nextInt();
			}
		}
		int max1 = 0;
		for(int i=0; i< n; i++) {
			for(int j=0; j< m; j++) {
				int tmp = dfs(array, i, j, 0);
				if(max1 < tmp)
					max1 = tmp;
			}
		}
		int max2 = 0;
		for(int i=0; i< n; i++) {
			for(int j=0; j< m; j++) {
				int tmp = case1(array, i, j);
				if(max1 < tmp)
					max1 = tmp;
			}
		}
		
		System.out.println(Math.max(max1, max2));
	}
	
	public int dfs(int array[][], int row, int col, int depth) {
		if(depth == 4) return 0;
		int sums[] = new int[4];
		if(row -1 >=0 && visited[row-1][col] == 0) {
			visited[row][col] = 1;
			sums[0] = array[row][col] + dfs(array, row-1, col, depth+1);
			visited[row][col] = 0;
		}
		if(row +1 < array.length && visited[row+1][col] == 0) {
			visited[row][col] = 1;
			sums[1] = array[row][col] + dfs(array, row+1, col, depth+1);
			visited[row][col] = 0;
		}
		if(col -1 >=0 && visited[row][col-1] == 0) {
			visited[row][col] = 1;
			sums[2] = array[row][col] + dfs(array, row, col-1, depth+1);
			visited[row][col] = 0;
		}
		if(col +1 < array[0].length && visited[row][col+1] == 0) {
			visited[row][col] = 1;
			sums[3] = array[row][col] + dfs(array, row, col+1, depth+1);
			visited[row][col] = 0;
		}
		return getMax(sums);
	}
	
	
	public int case1(int array[][], int row, int col) {
		int sums[] = new int[4];
		if(row+1 < array.length && col-1 >=0 && col+1 < array[0].length) {
			sums[0] = array[row][col] + array[row+1][col] + array[row+1][col-1] + array[row+1][col+1];
		}
		if(row-1 >=0 && col-1 >=0 && col+1 < array[0].length) {
			sums[1] = array[row][col] + array[row-1][col] + array[row-1][col-1] + array[row-1][col+1];
		}
		if(col +1 < array[0].length && row-1 >=0 && row+1 < array.length) {
			sums[2] = array[row][col] + array[row][col+1] + array[row-1][col+1] + array[row+1][col+1];
		}
		if(col -1 >=0 && row-1 >=0 && row+1 < array.length) {
			sums[3] = array[row][col] + array[row][col-1] + array[row-1][col-1] + array[row+1][col-1];
		}
		int max = getMax(sums);
		return max;
		
	}
	

	

	public int getMax(int array[]) {
		int max = array[0];
		for(int i=1; i< array.length; i++) {
			if(max < array[i])
				max = array[i];
		}		
		return max;
	}
	
	
	

}