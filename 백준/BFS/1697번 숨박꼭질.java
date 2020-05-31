import java.io.*;
import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.solution();

	}

	public void solution() {
		int n = scan.nextInt();
		int k = scan.nextInt();
		bfs(n, k);
	}
	
	public void bfs(int node, int k) {
		boolean visited[] = new boolean[100001];
		Queue<S> queue = new LinkedList<>();
		visited[node] = true;
		S s = new S(node, 0);
		queue.offer(s);
		int cnt=0;
		while(!queue.isEmpty()) {
			S curr = queue.poll();
			if(curr.node == k) {
				System.out.println(curr.cnt);
				return;
			}
			if(curr.node < 0) continue;
			if(curr.node-1 >=0 && !visited[curr.node-1]) {
				queue.offer(new S(curr.node-1, curr.cnt+1));
				visited[curr.node-1] = true;
			}
			if(curr.node*2 < 100001 && !visited[curr.node*2]) {
				queue.offer(new S(curr.node*2, curr.cnt+1));
				visited[curr.node*2] = true;
			}
			if(curr.node+1 <= 100001 && !visited[curr.node+1]) {
				queue.offer(new S(curr.node+1, curr.cnt+1));
				visited[curr.node+1] = true;
			}
		}
		
	}
	
	class S {
		int node;
		int cnt ;
		S(int node, int cnt){
			this.node = node;
			this.cnt = cnt;
		}
	}
	
}