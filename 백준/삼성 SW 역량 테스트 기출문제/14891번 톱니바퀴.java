import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int gears[][] = new int[4][8];
	boolean visited[] = new boolean[4];

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		for (int i = 0; i < 4; i++) {
			String str = scan.next();
			for (int j = 0; j < 8; j++) {
				gears[i][j] = str.charAt(j) - '0';
			}
		}

		int k = scan.nextInt();
		int rotations[][] = new int[k][2];
		
		for (int i = 0; i < k; i++) {
			rotations[i][0] = scan.nextInt();
			rotations[i][1] = scan.nextInt();
		}

		for (int i = 0; i < k; i++) {
			int n = rotations[i][0];
			int d = rotations[i][1];
			rotate(n - 1, d);
		}
		
		int sum = 0;
		int c = 1;
		
		for(int i = 0; i < 4; i++) {
			if(gears[i][0] == 1)
				sum += c;
			
			c *= 2;
		}
		
		System.out.println(sum);
	}

	public void rotate(int n, int d) {
		visited[n] = true;

		if (n > 0) {
			if (gears[n][6] != gears[n - 1][2] && !visited[n - 1]) {
				rotate(n - 1, -d);
			}
		}

		if (n < 3) {
			if (gears[n][2] != gears[n + 1][6] && !visited[n + 1]) {
				rotate(n + 1, -d);
			}
		}
		
		if(d == 1) {
			clockWise(n);
			
		} else if(d == -1) {
			counterClockWise(n);
		}
		
		visited[n] = false;
	}
	
	public void clockWise(int n) {
		int tmp = gears[n][7];
		
		for(int i = 7; i >= 1; i--) {
			gears[n][i] = gears[n][i - 1];
		}
		
		gears[n][0] = tmp;
	}
	
	public void counterClockWise(int n) {
		int tmp = gears[n][0];
		
		for(int i = 0; i < 7; i++) {
			gears[n][i] = gears[n][i + 1];
		}
		
		gears[n][7] = tmp;
	}
}