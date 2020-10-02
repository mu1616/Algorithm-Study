import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int dx[] = {-1, 1, 0, 0};
	int dy[] = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int r = scan.nextInt();
		int c = scan.nextInt();
		int n = scan.nextInt();
		char map[][] = new char[r][c];
		
		for(int i = 0; i < r; i++) {
			String str = scan.next();
			for(int j = 0; j < c;j ++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int board[][] = new int[r][c];
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c;j ++) {
				if(map[i][j] == '.') board[i][j] = -1;
				if(map[i][j] == 'O') board[i][j] = 3;
			}
		}
		
		int time = 0;
		while(time < n) {
			workTimer(board);
			
			if(time == 0) {
				time++;
				continue;
			}
			
			if(time % 2 != 0) {
				setBomb(board);	
			}
			
			time++;
			explode(board);
		}
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == -1) System.out.print('.');
				if(board[i][j] != -1) System.out.print('O');
			}
			System.out.println();
		}
	}
	
	public void workTimer(int board[][]) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] != -1) board[i][j] -= 1;
			}
		}
	}
	
	public void setBomb(int board[][]) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == -1) board[i][j] = 3;
			}
		}
	}
	
	public void explode(int board[][]) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == 0) {
					board[i][j] = -1;
					for(int k = 0; k < 4; k++) {
						int nx = j + dx[k];
						int ny = i + dy[k];
						if(nx >= 0 && nx < board[0].length && ny >= 0 && ny < board.length) {
							if(board[ny][nx] != 0) {
								board[ny][nx] = -1;
							}
						}
					}
				}
			}
		}
	}
}