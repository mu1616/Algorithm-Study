import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int map[][];
	int dx[] = {0, 1, 0, -1};
	int dy[] = {-1, 0, 1, 0};
	int cnt;
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int m = scan.nextInt();
		map = new int[n][m];
		int r = scan.nextInt();
		int c = scan.nextInt();
		int d = scan.nextInt();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		
		recursion(c, r, d);
		System.out.println(cnt);
	}
	
	public void recursion(int x, int y, int d) {
		if(map[y][x] == 0) {
			map[y][x] = 2;
			cnt++;
		}
		
		boolean possible = false;
		int nd = d;
		
		for(int i = 0; i < 4; i++) {
			nd = (nd - 1 < 0 ) ? 3 : nd - 1; //다음 방향	
			int nx = x + dx[nd];
			int ny = y + dy[nd];
			
			if(map[ny][nx] == 0) {
				recursion(nx, ny, nd);
				possible = true;
				break;
			}
		}
			
		if(!possible) {
			nd = (d + 2) % 4;
			int nx = x + dx[nd];
			int ny = y + dy[nd];
			if(map[ny][nx] != 1) recursion(nx, ny, d);
		}
	}
}