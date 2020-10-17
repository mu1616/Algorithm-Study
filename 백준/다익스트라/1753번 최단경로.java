package algorithm;

import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	ArrayList<Node> graph[];

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int V = scan.nextInt();
		int E = scan.nextInt();
		int K = scan.nextInt() - 1;
		graph = new ArrayList[V];
		for(int i = 0; i < V; i++) graph[i] = new ArrayList<>();
		
		for (int i = 0; i < E; i++) {
			int u = scan.nextInt() - 1;
			int v = scan.nextInt() - 1;
			int w = scan.nextInt();
			graph[u].add(new Node(v, w));
		}

		dijkstra(K, V);
	}

	public void dijkstra(int start, int V) {
		boolean visited[] = new boolean[V];
		int dist[] = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>((node1, node2) -> {
			return node1.w - node2.w;
		});
		dist[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(visited[curr.v]) continue;
			visited[curr.v] = true;
			
			for(Node next : graph[curr.v]) {
				if(dist[next.v] > dist[curr.v] + next.w) {
					dist[next.v] = dist[curr.v] + next.w;
					pq.offer(new Node(next.v, dist[next.v]));
				}
			}
				
		}
		
		for(int i = 0 ; i < V; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
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