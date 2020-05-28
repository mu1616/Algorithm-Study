import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	static int k = 2;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		Main main = new Main();
		int n = scan.nextInt();
		int array[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			String tmp = scan.next();
			for (int j = 0; j < n; j++) {
				array[i][j] = tmp.charAt(j) - 48;
			}
		}
		for(int i=0; i< n; i++) {
			for(int j=0; j< n; j++) {
				if(array[i][j]==1) {
					int count = recursion(array, i, j);
					list.add(count);
					k++;
				}
			}
		}
		System.out.println(list.size());
		Collections.sort(list);
		for(int i : list)
			System.out.println(i);
	}

	static int recursion(int array[][], int row, int col) {
		int nextRow = row + 1;
		int nextCol = col + 1;
		int beforeRow = row - 1;
		int beforeCol = col - 1;
		int count = 1;
		array[row][col] = k;
		if(nextRow < array.length && array[nextRow][col]==1) {
			count += recursion(array, nextRow, col);
		}
		if(nextCol < array.length && array[row][nextCol] == 1) {
			count += recursion(array, row, nextCol);
		}
		if(beforeRow >=0 && array[beforeRow][col] == 1) {
			count += recursion(array, beforeRow, col);
		}
		if(beforeCol >=0 && array[row][beforeCol] == 1) {
			count += recursion(array, row, beforeCol);
		}
		return count;
	}

}