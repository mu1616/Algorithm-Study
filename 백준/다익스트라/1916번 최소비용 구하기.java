import java.util.*;
import java.util.stream.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int dist[];
	List<Node> list[];
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int m = scan.nextInt();
		list = new ArrayList[n + 1];
		for(int i = 0; i < n + 1; i++) list[i] = new ArrayList<>();
		for(int i = 0; i < m; i++) {
			int u = scan.nextInt();
			int v = scan.nextInt();
			int w = scan.nextInt();
			list[u].add(new Node(v, w));
		}
		
		int u = scan.nextInt();
		int v = scan.nextInt();
		
		dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dijkstra(u, n);
		
		System.out.println(dist[v]);
	}
	
	public void dijkstra(int start, int n) {
		boolean visited[] = new boolean[n + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>((node1, node2) -> {
			return node1.w - node2.w;
		});
		dist[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(visited[curr.v]) continue;
			visited[curr.v] = true; 
			
			for(Node next : list[curr.v]) {
				if(dist[next.v] > dist[curr.v] + next.w) {
					dist[next.v] = dist[curr.v] + next.w;  
					pq.offer(new Node(next.v, dist[next.v]));
				}
			}
		}
	}
	
	class Node {
		int v;
		int w;
		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
}