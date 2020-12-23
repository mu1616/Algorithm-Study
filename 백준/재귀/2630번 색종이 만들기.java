package algorithm;

import java.util.*;


// 너무 어렵게 생각해서 풀었는데
// 재귀로 풀면 더 쉬움!! 

class Main {
	static Scanner scan = new Scanner(System.in);
	public static int VISITED = 3;
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int array[][] = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				array[i][j] = scan.nextInt();
			}
		}
		
		int counts[] = new int[2]; // counts[0] = 하얀색개수, counts[1] = 파란색개수
		
		int paperLength = n;
		while(paperLength >= 1) {
			for(int i = 0; i < n; i += paperLength) {
				for (int j = 0; j < n; j+= paperLength) {
					if(array[i][j] == VISITED) {
						continue;
					}
					if (isSame(array, j, i, paperLength)) {
						counts[array[i][j]]++;
						visit(array, j, i, paperLength);
					}
				}
			}
			
			paperLength = paperLength / 2;
		}
		
		System.out.println(counts[0]);
		System.out.println(counts[1]);
	}
	
	public boolean isSame(int array[][], int x, int y, int length) {
		int color = array[y][x];
		for(int i = y; i < y + length; i++) {
			for(int j = x ; j < x + length; j++) {
				if(array[i][j] != color) {
					return false;
				}
			}
		}

		return true;
	}
	
	public void visit(int array[][], int x, int y, int length) {
		for(int i = y; i < y + length; i++) {
			for(int j = x ; j < x + length; j++) {
				array[i][j] = VISITED;
			}
		}
	}
}