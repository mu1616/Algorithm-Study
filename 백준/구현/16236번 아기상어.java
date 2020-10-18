import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int map[][];
	Shark shark;
	int dx[] = {0, -1, 1, 0};
	int dy[] = {-1, 0, 0, 1};
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = scan.nextInt();
				if(map[i][j] == 9) {
					shark = new Shark(j, i, 0);
					map[i][j] = 0;
				}
			}
		}
		
		int answer = 0;
		while(true) {
			int time = find();
			if(time == -1) break;
			answer += time;
		}
		
		System.out.println(answer);
	}
	
	public int find() {
		boolean visited[][] = new boolean[map.length][map.length];
		PriorityQueue<Shark> queue = new PriorityQueue<>((shark1, shark2) -> {
			if(shark1.time != shark2.time) return shark1.time - shark2.time;
			if(shark1.y != shark2.y) return shark1.y - shark2.y;
			return shark1.x -shark2.x;
		});
		queue.offer(new Shark(shark.x, shark.y, 0));
		visited[shark.y][shark.x] = true; 
		
		while(!queue.isEmpty()) {
			Shark curr = queue.poll();
			
			if(map[curr.y][curr.x] != 0 && shark.size > map[curr.y][curr.x]) {
				shark.exp += 1;
				if(shark.exp == shark.size) {
					shark.size += 1;
					shark.exp = 0;
				}
				shark.x = curr.x;
				shark.y = curr.y;
				map[curr.y][curr.x] = 0; 
				return curr.time;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				if(nx >= 0 && nx < map.length && ny >=0 && ny < map.length) {
					if(!visited[ny][nx] && shark.size >= map[ny][nx]) {
						queue.offer(new Shark(nx, ny, curr.time + 1));
						visited[ny][nx] = true;
					}
				}
			}
		}
		
		return -1;
	}

	class Shark {
		int x;
		int y;
		int size = 2;
		int exp;
		int time;
		Shark(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
}