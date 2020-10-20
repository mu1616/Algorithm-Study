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
		int n = scan.nextInt();
		int m = scan.nextInt();
		int map[][] = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		
		int beforeMap[][] = new int[n][m];
		int time = 0;
		
		while(!isAllMelt(map)) {
			beforeMap = map;
			devideSection(map);
			map = passOneSec(map);
			time++;
		}
		
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j< m; j++) {
				if(beforeMap[i][j] == 1) cnt++;
			}
		}
		
		System.out.println(time);
		System.out.println(cnt);
	}
	
	public void devideSection(int map[][]) {
		boolean visited[][] = new boolean[map.length][map[0].length];
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(0, 0));
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				
				if(nx >= 0 && nx < map[0].length && ny >= 0 && ny < map.length) {
					if(!visited[ny][nx] && map[ny][nx] == 0) {
						visited[ny][nx] = true;
						queue.offer(new Node(nx, ny));
						map[ny][nx] = 3;
					}
				}
			}
		}
	}
	
	public int[][] passOneSec(int map[][]) {
		int newMap[][] = new int[map.length][map[0].length];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				if(map[i][j] == 0) {
					continue;
				}
				
				boolean isCheese = true;
				for(int k = 0; k< 4; k++) {
					int x = j + dx[k];
					int y = i + dy[k];
					
					if(x >= 0 && x < map[0].length && y >= 0 && y < map.length) {
						if(map[y][x] == 3) {
							isCheese = false;
							break;
						}
					}
				}
				
				if(isCheese) {
					newMap[i][j] = 1;
				} else {
					newMap[i][j] = 0;
				}
			}
		}
		
		return newMap;
	}
	
	public boolean isAllMelt(int map[][]) {
		boolean isAllMelt = true;
		loop:
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				if(map[i][j] == 1) {
					isAllMelt = false;
					break loop;
				}
			}
		}
		
		return isAllMelt;
	}
	
	class Node {
		int x;
		int y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}