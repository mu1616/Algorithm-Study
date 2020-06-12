import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int office[][];
	int n;
	int m;
	int min;
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		n = scan.nextInt();
		m = scan.nextInt();
		office = new int[n][m];
		min = n*m;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				office[i][j] = scan.nextInt();
			}
		}
		//printArray(up(down(office, 14),14));
		recursion(office, 0);
		System.out.println(min);
	}

	public void recursion(int array[][], int start) {
		if (start == n * m) {
			int sum = 0;
			for(int i =0; i< array.length; i++) {
				for(int j=0; j< array[0].length; j++) {
					if(array[i][j] ==0)
						sum++;
				}
			}
			if(min > sum) min = sum;

			return;
		}
		int row = start / m;
		int col = start % m;
		if (array[row][col] == 1) {
			recursion(right(array, start), start+1);
			recursion(left(array, start), start+1);
			recursion(up(array, start), start+1);
			recursion(down(array, start), start+1);
		} else if (array[row][col] == 2) {
			recursion(left(right(array, start), start), start+1);
			recursion(up(down(array, start), start), start+1);
		} else if (array[row][col] == 3) {
			recursion(right(up(array, start), start), start+1);
			recursion(left(up(array, start), start), start+1);
			recursion(left(down(array, start), start), start+1);
			recursion(right(down(array, start), start), start+1);
		} else if (array[row][col] == 4) {
			recursion(right(left(up(array, start), start), start), start+1);
			recursion(right(up(down(array, start), start), start), start+1);
			recursion(left(right(down(array, start), start), start), start+1);
			recursion(left(up(down(array, start), start), start), start+1);
		} else if (array[row][col] == 5) {
			recursion(right(left(down(up(array, start), start), start), start), start+1);
		} else {
			recursion(array, start + 1);
		}

	}

	public int[][] right(int array[][], int start) {
		int row = start / m;
		int col = start % m;
		int copy[][] = copy(array);
		for(int i=col+1; i< array[0].length; i++) {
			if(copy[row][i] == 6) break;
			if(copy[row][i] == 0)
				copy[row][i] = 7;
		}
		return copy;
	}

	public int[][] left(int array[][], int start) {
		int row = start / m;
		int col = start % m;
		int copy[][] = copy(array);
		for(int i=col-1; i>=0; i--) {
			if(copy[row][i] == 6) break;
			if(copy[row][i] == 0)
				copy[row][i] = 7;
		}
		return copy;
	}

	public int[][] up(int array[][], int start) {
		int row = start / m;
		int col = start % m;
		int copy[][] = copy(array);
		for(int i=row-1; i>=0; i--) {
			if(copy[i][col] == 6) break;
			if(copy[i][col] == 0)
				copy[i][col] = 7;
		}
		return copy;
	}

	public int[][] down(int array[][], int start) {
		int row = start / m;
		int col = start % m;
		int copy[][] = copy(array);
		for(int i=row+1; i< array.length; i++) {
			if(copy[i][col] == 6) break;
			if(copy[i][col] == 0)
				copy[i][col] = 7;
		}
		return copy;
	}



	public int[][] copy(int array[][]) {
		int copy[][] = new int[array.length][array[0].length];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				copy[i][j] = array[i][j];
			}
		}
		return copy;
	}
	
	public void printArray(int array[][]) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}

}
