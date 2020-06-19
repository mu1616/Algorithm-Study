import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int hit;
	int d;
	int dx[] = {-1, 0, 1};
	int dy[] = {0, -1, 0};
	int location[];
	int n;
	int m;
	int max;
	int array[][];
	Stack<Integer> st = new Stack<>();
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		n = scan.nextInt();
		m = scan.nextInt();
		d = scan.nextInt();
	
		array = new int[n+1][m];
		location = new int[m];
		
		for(int i=0; i< n; i++) {
			for(int j=0; j< m; j++) {
				array[i][j] = scan.nextInt();
			}
		}
		
		for(int i=0; i< m; i++)
			location[i] = i;
			
		combi(0, 3);
		System.out.println(max);
		
	}
	
	public void bfs(int array[][], int x[], int y[]) {
		boolean visited[] = new boolean[3];  //화살 hit 여부
		Queue<Node> queue = new LinkedList<>();
		
		for(int i=0; i< x.length; i++) {
			queue.offer(new Node(x[i], y[i], 0, i));
		}
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			
			if(visited[curr.idx] == true)  //이미 hit한 궁수의 화살이라면
				continue;
			
			if(array[curr.y][curr.x] == 1 ) {  //0 == 없음 , 1 == 적군, 2 == 시체
				array[curr.y][curr.x] = 2;
				visited[curr.idx] = true; 
				hit++;
				continue;
			}
			
			if(array[curr.y][curr.x] == 2) {
				visited[curr.idx]= true;
				continue;
			}
			
			for(int i=0; i< 3; i++) {
				if(curr.dist == 0 && (i == 0 || i == 2)) //현재 dist가 0이라면 화살은 위로만 이동 가능
					continue;
				
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				
				if(curr.dist < d && nx >=0 && nx < array[0].length && ny >=0 && ny < array.length)
					queue.offer(new Node(nx, ny, curr.dist + 1, curr.idx));
			}
		}
		
	}
	
	public void turn(int [][]array) {
		for(int i= array.length-2; i>=1; i--) {
			for(int j=0; j< array[0].length; j++) {
				array[i][j] = array[i-1][j];
				array[i-1][j] = 0;
				if(array[i][j] == 2) 
					array[i][j] = 0;
			}
		}
	}
	
	public void combi(int start, int r) {
		if(r == 0) {
			int x[] = new int[3];
			int y[] = new int[3];
			
			for(int i=0; i< 3; i++) {
				x[i] = st.get(i);
				y[i] = n;
			}
			hit = 0;
			
			int copy[][] = copy(array);
			for(int i=0; i< n; i++) {
				bfs(copy, x, y);
				turn(copy);
			}
			
			if(max < hit)
				max = hit;
			
		} else {
			for(int i = start; i < location.length; i++) {
				st.push(location[i]);
				combi(i+1, r-1);
				st.pop();
			}
		}
	}
	
	public int[][] copy(int [][] array) {
		int copy[][] = new int[array.length][array[0].length];
		for(int i=0; i< array.length; i++) {
			for(int j=0; j< array[0].length; j++) {
				copy[i][j] = array[i][j];
			}
		}
		return copy;
	}
	
	class Node{   //화살
		int idx;  //누구의 화살인가
		int x;
		int y;
		int dist;
		Node(int x, int y, int dist, int idx) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.idx = idx;
		}
	}
}
