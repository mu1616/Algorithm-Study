import java.util.*;
import java.io.*;
class Main {
	static Scanner scan = new Scanner(System.in);
	int graph[][];
	boolean visited[];
	int n;
	public static void main(String[] args){
		Main main = new Main();
		main.solution();
	}
	
	public void solution() {
		n = scan.nextInt();
		graph = new int[n][n];
		visited = new boolean[n];
		int a = scan.nextInt();
		int b = scan.nextInt();
		int m = scan.nextInt();
		
		for(int i = 0; i < m; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			graph[x - 1][y - 1] = 1;
			graph[y - 1][x - 1] = 1;
		}
		
		System.out.println(bfs(a - 1, b - 1));
	}
	
	public int bfs(int start, int target) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(start, 0));
		visited[start] = true;
		int result = -1;
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			
			if(curr.idx == target) {
				result = curr.depth;
				break;
			}
			
			for(int next = 0; next < n; next++) {
				if(!visited[next] && graph[next][curr.idx] == 1) {
					visited[next] = true;
					queue.offer(new Node(next, curr.depth + 1));
				}
			}
		}
		
		return result;
	}
	
	class Node {
		int idx;
		int depth;
		
		Node(int idx, int depth) {
			this.idx = idx;
			this.depth = depth;
		}
	}
}