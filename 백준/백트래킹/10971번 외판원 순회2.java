import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int w[][];
	boolean visited[];
	int min = Integer.MAX_VALUE;
			
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		w = new int[n][n];
		visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				w[i][j] = scan.nextInt();
			}
		}
		
		recursion(0, 0, 0);
		System.out.println(min);
	}
	
	public void recursion(int loc, int dist, int depth) {
		visited[loc] = true;
				
		for(int i = 0; i < w.length; i++) {
			if(!visited[i] && w[loc][i] != 0) {
				recursion(i, dist + w[loc][i], depth + 1);
			}
		}
		
		if(depth == w.length - 1 && w[loc][0] != 0) {
			dist += w[loc][0];
			if(min > dist) 
				min = dist;
		}
		
		visited[loc] = false;
	}
	
}