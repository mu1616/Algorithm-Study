import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int array[][];
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int max = 0;
		int n = scan.nextInt();
		array = new int[n][n];
		for(int i=0; i< n; i++) {
			for(int j=0; j< n; j++) {
				array[i][j] = scan.nextInt();
				if(max < array[i][j]) max = array[i][j];
			}
		}
		int result = 0;
		for(int i=0; i <=max; i++) {
			int cnt = 0;
			boolean visited[][] = new boolean[n][n];
			for(int j=0; j< n; j++) {
				for(int k=0; k< n; k++) {
					if(visited[j][k] ==false && array[j][k] > i) {
						dfs(j, k, i, visited);
						cnt++;
					}
				}
			}
			if(result < cnt) result = cnt;
		}
		System.out.println(result);
		
	}
	
	public void dfs(int row, int col, int height, boolean visited[][]) {
		visited[row][col] = true;
		if(col+1 < array.length && array[row][col+1] > height && visited[row][col+1] == false) {
			dfs(row, col+1, height, visited);
		}
		if(row+1 < array.length && array[row+1][col] > height && visited[row+1][col] == false) {
			dfs(row+1, col, height, visited);
		}
		if(col-1 >=0 && array[row][col-1] > height && visited[row][col-1] == false) {
			dfs(row, col-1, height, visited);
		}
		if(row-1 >=0 && array[row-1][col] > height && visited[row-1][col] == false) {
			dfs(row-1, col, height, visited);
		}
	}
	


}