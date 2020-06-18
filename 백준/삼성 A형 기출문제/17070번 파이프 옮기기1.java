import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int array[][];
	int dx[] = {1, 0, 1};
	int dy[] = {0, 1, 1};
	int result;
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		array = new int[n][n];
		
		for(int i=0; i< n; i++) {
			for(int j=0; j< n; j++) {
				array[i][j] = scan.nextInt();
			}
		}
		
		recursion(1, 0, 1);
		
		System.out.println(result);
	}
	
	public void recursion(int x, int y, int state) {   //state - 1:가로, 2: 세로, 3: 대각선
		if(x == array.length-1 && y == array.length-1) {
			result++;
			return;
		}
		if(state == 1 || state == 3) {
			if(x+1 < array.length && array[y][x+1] == 0) {
				recursion(x+1, y, 1);
			}
		}
		
		if(state == 2 || state == 3) {
			if(y+1 < array.length && array[y+1][x] == 0) {
				recursion(x, y+1, 2);
			}
		}
	
		if(check(x, y)) {
			recursion(x+1, y+1, 3);
		}
	}
	
	public boolean check(int x, int y) {
		for(int i=0; i< 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(!(nx < array.length && ny < array.length && array[ny][nx] == 0)) {
				return false;
			}
		}
		return true;
	}
}

