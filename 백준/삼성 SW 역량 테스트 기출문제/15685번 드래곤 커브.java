import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int map[][] = new int[101][101];
	int dx[] = {1, 0, -1, 0};
	int dy[] = {0, -1, 0, 1};
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		Dragon dragons[] = new Dragon[n];
		
		for(int i = 0; i < n; i++) {
			dragons[i] = new Dragon(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt());
		}
		
		for(int i = 0; i < dragons.length; i++) {
			ArrayList<Integer> dList = new ArrayList<>();
			dList.add(dragons[i].d);
			map[dragons[i].y][dragons[i].x]= 1;
			
			int x = dragons[i].x + dx[dragons[i].d];
			int y = dragons[i].y + dy[dragons[i].d];
			map[y][x] = 1;
			
			for(int j = 0; j < dragons[i].g; j++) {
				for(int k = dList.size() - 1; k >=0; k--) {
					int d = (dList.get(k) + 1) % 4;
					x = x + dx[d];
					y = y + dy[d];
					map[y][x] = 1;
					dList.add(d);
				}
			}
		}
		
		int result = 0;
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++) {
				if(i < map.length - 1 && j < map.length - 1) {
					if(map[i][j] == 1 && map[i + 1][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j + 1] == 1) {
						result++;
					}
				}
			}
		}
		
		System.out.println(result);
	}

	class Dragon {
		int x;
		int y;
		int d;
		int g;
		
		Dragon(int x, int y, int d, int g) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.g = g;
		}
	}
}
