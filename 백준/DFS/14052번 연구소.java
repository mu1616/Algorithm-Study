import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	static int n;
	static int m;
	static int cnt;
	static int copy[][];
	static int max;
	public static void main(String[] args) {
		Main main = new Main();
		n = scan.nextInt();
		m = scan.nextInt();
		copy = new int[n][m];
		int [][] array = new int[n][m];
		for(int i=0; i< n; i++) {
			for(int j=0; j< m; j++) {
				array[i][j] = scan.nextInt();
			}
		}
	
		setWall(array, 0, 0, 3);		
		System.out.println(max);
	}
	
	static void setWall(int [][]array, int row, int col, int r) {
		if(r==0) {
			copyMap(array);
			for(int i=0; i< n; i++) {
				for(int j=0; j< m; j++) {
					if(array[i][j]==2)
						spread(copy, i, j);
				}
			}
			int tmp = counting(copy);
			if(max < tmp) 
				max = tmp;
			return;
		}
		int length = (n*m) - (m*row) - col;
		for(int i=0; i< length; i++) {
			if(array[row][col]==0) {
				array[row][col] = 1;
				if(col+1 < m) setWall(array, row, col+1, r-1);
				else setWall(array, row+1, 0, r-1);
				array[row][col] = 0;
			}
			if(col+1 < m) {
				col++;
			}else {
				row++;
				col = 0;
			}
		}
	}
	
	static void copyMap(int [][]array) {
		for(int i=0; i< n; i++) {
			for(int j=0; j< m; j++) {
				copy[i][j] = array[i][j];
			}
		}
	}
	
	static void spread(int [][]array, int row, int col) {
		int nextRow = row + 1;
		int nextCol = col + 1;
		int beforeRow = row - 1;
		int beforeCol = col - 1;
		
		if(nextRow<n && array[nextRow][col] == 0) {
			array[nextRow][col] = 2;
			spread(array, nextRow, col);
		}
		if(nextCol<m && array[row][nextCol] ==0 ) {
			array[row][nextCol] = 2;
			spread(array, row, nextCol);
		}
		if(beforeRow >=0 && array[beforeRow][col] == 0 )  {
			array[beforeRow][col] = 2;
			spread(array, beforeRow, col);
		}
		if(beforeCol >=0 && array[row][beforeCol] ==0) {
			array[row][beforeCol] = 2;
			spread(array, row, beforeCol);
		}
	}
		
	static int counting(int [][]array){
		int sum = 0;
		for(int i=0; i< n; i++) {
			for(int j=0; j< m; j++) {
				if(array[i][j]==0) 
					sum++;
			}
		}
		return sum;
	}

	

}