import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int array[][][];
	boolean visited[][][];
	int dist[][][];
	int h[] = {-1, 1, 0, 0, 0, 0};
	int n[] = {0, 0, 1, -1, 0, 0};
	int m[] = {0, 0, 0, 0, 1, -1};
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int m = scan.nextInt();
		int n = scan.nextInt();
		int h = scan.nextInt();
		array = new int[h][n][m];
		visited = new boolean[h][n][m];
		dist = new int[h][n][m];
		for(int i=0; i< h; i++) {
			for(int j=0; j< n; j++) {
				for(int k=0; k< m; k++) {
					array[i][j][k] = scan.nextInt();
				}
			}
		}
		bfs();
		int result = 0;
		a:for(int i=0; i< h; i++) {
			for(int j=0; j< n; j++) {
				for(int k=0; k< m; k++) {
					if(array[i][j][k]==0) {
						result = -1;
						break a;
					}
					if(dist[i][j][k] > result) {
						result = dist[i][j][k];
					}
				}
			}
		}
		System.out.println(result);
	}

	public void bfs() {
		Queue<Tomato> queue = new LinkedList<>();
		for(int i=0; i< array.length; i++) {
			for(int j=0; j< array[0].length; j++) {
				for(int k=0; k< array[0][0].length; k++) {
					if(array[i][j][k] == 1 && visited[i][j][k] == false) {
						visited[i][j][k] = true;
						queue.offer(new Tomato(i,j,k));
					}
				}
			}
		}
		while(!queue.isEmpty()) {
			Tomato curr = queue.poll();
			
			for(int i=0; i< 6; i++) {
				if(curr.h + h[i] >= 0 && curr.h + h[i] < array.length && curr.n + n[i] >=0 && curr.n + n[i] < array[0].length 
						&& curr.m + m[i] >=0 && curr.m + m[i] < array[0][0].length) {
					if(visited[curr.h + h[i]][curr.n + n[i]][curr.m + m[i]] == false 
							&& array[curr.h + h[i]][curr.n + n[i]][curr.m + m[i]] == 0) {
						visited[curr.h + h[i]][curr.n + n[i]][curr.m + m[i]] = true;
						dist[curr.h + h[i]][curr.n + n[i]][curr.m + m[i]] = dist[curr.h][curr.n][curr.m] + 1;
						array[curr.h + h[i]][curr.n + n[i]][curr.m + m[i]] = 1;
						queue.offer(new Tomato(curr.h + h[i], curr.n + n[i], curr.m + m[i]));
					}
				}
			}
		}
	}
	
	class Tomato{
		int h;
		int n;
		int m;
		Tomato(int h, int n, int m){
			this.h = h;
			this.n = n;
			this.m = m;
		}
		@Override
		public String toString() {
			return "Tomato [h=" + h + ", n=" + n + ", m=" + m + "]";
		}
		
	}

}