import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int answer[][] = new int[9][9];
	public static void main(String[] args) {
		Main m = new Main();
		m.solution();
	}

	public void solution() {
		int array[][] = new int[9][9];
		int cnt = 0;
		for(int i=0; i< 9; i++) {
			for(int j=0; j< 9; j++) {
				array[i][j] = scan.nextInt();
				if(array[i][j]==0) cnt++;
			}
		}
		a :for(int i=0; i< array.length; i++) {
			for(int j=0; j< array[0].length; j++) {
				if(array[i][j] ==0 ) {
					recursion(array, i, j, cnt);
					break a;
				}	
			}
		}
	}
	
	public void recursion(int array[][], int row, int col, int cnt) {
		int visited[] = new int[10];
		int startRow = 3*(row/3);
		int startCol = 3*(col/3);
		for(int i=0; i< 9; i++) {
			if(visited[array[row][i]] == 0 && array[row][i] !=0) 
				visited[array[row][i]] = 1;
			if(visited[array[i][col]] == 0 && array[i][col] !=0) 
				visited[array[i][col]] = 1;
			if(visited[array[startRow+i/3][startCol+i%3]] ==0 && array[startRow+i/3][startCol+i%3] !=0)
				visited[array[startRow+i/3][startCol+i%3]] = 1;
			
		}
		for(int i=1; i< 10; i++) {
			if(visited[i]==0) {
				array[row][col] = i;
				b:for(int j=row; j< 9; j++) {
					int start = (j==row)?col:0;
					for(int k= start; k< 9; k++) {
						if(array[j][k] == 0) {
							recursion(array, j, k, cnt-1);
							array[row][col] = 0;
							break b;
						}
					}
				}
			}
		}
		int end = 1;
		if(cnt ==1) {
			for(int i=0; i< 9; i++) {
				for(int j=0; j< 9; j++) {
					if(array[i][j]==0)
						end = 0;
				}
			}
			if(end==1) {
				printArray(array);
				System.exit(0);
			}
				
		}
	}
	
	public void printArray(int array[][]) {
		for(int i=0; i< array.length; i++) {
			for(int j=0; j< array[0].length ;j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void printArray2(int array[]) {
		for(int i=0; i< array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
}