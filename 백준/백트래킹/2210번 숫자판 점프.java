import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	HashSet<String> set = new HashSet<>();
	int dx[] = {-1, 1, 0, 0};
	int dy[] = {0, 0, -1, 1};
	int array[][];
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		array = new int[5][5];
		
		for(int i=0; i< 5; i++) {
			for(int j=0; j< 5; j++) {
				array[i][j] = scan.nextInt();
			}
		}
		
		for(int i=0; i< 5; i++) {
			for(int j=0; j< 5; j++) {
				bfs(j, i);
			}
		}
		
		
		System.out.print(set.size());
	}
	
	public void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, y, 0, String.valueOf(array[y][x])));
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			if(curr.depth ==5) {
				set.add(curr.sum);
				continue;
			}
			for(int i=0; i< 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				if(nx >=0 && nx < 5 && ny >=0 && ny < 5) {
					if(curr.depth < 5) {
						Node node = new Node(nx, ny, curr.depth + 1, curr.sum + array[ny][nx]);
						queue.offer(node);
					}
				}
			}
		}
	}
	
	class Node{
		int x;
		int y;
		int depth;
		String sum;
		
		Node(int x, int y, int depth, String sum){
			this.x = x;
			this.y = y;
			this.depth = depth;
			this.sum = sum;
		}
	}
}