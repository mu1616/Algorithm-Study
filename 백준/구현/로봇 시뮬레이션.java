import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int dx[] = {0, 1, 0, -1};
	int dy[] = {1, 0, -1, 0};
	int a;
	int b;
	int map[][];
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		a = scan.nextInt();
		b = scan.nextInt();
		map = new int[a + 1][b + 1];
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		Robot robots[] = new Robot[n + 1];
		for(int i = 1; i <= n; i++) {
			robots[i] = new Robot(scan.nextInt(), scan.nextInt(), scan.next().charAt(0));
			map[robots[i].x][robots[i].y] = i; 
		}
		
		for(int i = 0; i < m; i++) {
			int robot = scan.nextInt();
			int command = scan.next().charAt(0);
			int count = scan.nextInt();
			
			if(command == 'F') {
				if(!f(robots, robot, count)) {
					return;
				}
			}
			
			if(command == 'R') {
				robots[robot].d = (robots[robot].d + count) % 4;
			}
			
			if(command == 'L') {
				robots[robot].d = (robots[robot].d + (3*count)) % 4;
			}
		}
		System.out.print("OK");
	}
	
	public void print() {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j< map[0].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public boolean f(Robot robots[], int robot, int count) {
		Robot curr = robots[robot];
		int tmpX = curr.x;
		int tmpY = curr.y;
		
		for(int i = 0; i < count; i++) {
			int nx = curr.x + dx[curr.d];
			int ny = curr.y + dy[curr.d];
			
			if(!(nx >= 1 && nx <= a && ny >= 1 && ny <= b)) {
				System.out.printf("Robot %d crashes into the wall\n", robot);
				return false;
			}
			
			if(map[nx][ny] != 0) {
				System.out.printf("Robot %d crashes into robot %d\n", robot, map[nx][ny]);
				return false;
			}
			
			map[curr.x][curr.y] = 0;
			curr.x = nx;
			curr.y = ny;
			map[curr.x][curr.y] = robot; 
		}
		return true;
	}
	
	class Robot {
		int x;
		int y;
		int d;
		Robot(int x, int y, char d) {
			this.x = x;
			this.y = y;
			if(d == 'W') this.d = 3;
			if(d == 'N') this.d = 0;
			if(d == 'E') this.d = 1;
			if(d == 'S') this.d = 2;
		}
	}
}