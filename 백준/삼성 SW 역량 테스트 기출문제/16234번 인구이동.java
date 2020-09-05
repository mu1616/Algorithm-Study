import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	boolean visited[][];
	boolean flag = false;
	int dx[] = {1, -1, 0, 0};
	int dy[] = {0, 0, 1, -1};
	int people;
	int united;
	ArrayList<Integer> unitedList = new ArrayList<>();
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int l = scan.nextInt();
		int r = scan.nextInt();
		int map[][] = new int[n][n];
		visited = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		
		int cnt = 0;
		while(true) {
			flag = false;
			
			visited = new boolean[n][n];
			for(int i = 0; i < map.length ; i++) {
				for(int j = 0; j < map.length; j++) {
					if(!visited[i][j]) {
						people = 0;
						united = 0;
						unitedList.clear();
						dfs2(map, j, i, l , r);
						
						for(int k : unitedList) {
							int x = k % map.length;
							int y = k / map.length;
							map[y][x] = people/ united;
						}
					}
				}
			}
			
			if(flag == false) break;
			cnt++;
		}

		System.out.println(cnt);
		
	}
	
	public void dfs2(int map[][], int x, int y, int l, int r) {
		visited[y][x] = true;
		united++;
		people += map[y][x];
		unitedList.add(y*map.length + x);
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < map.length && ny >=0 && ny < map.length) { 
				int diff = Math.abs(map[y][x] - map[ny][nx]);
				if(!visited[ny][nx] && diff >= l && diff <= r) {
					flag = true;
					dfs2(map, nx, ny, l, r);
				}
			}
		}
	}
	
}