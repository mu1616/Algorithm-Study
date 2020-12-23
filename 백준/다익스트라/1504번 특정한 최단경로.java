package algorithm;

import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int dist[][];
	List<Node> list[];
	int v1, v2;
	static final int INF = 100000000;
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int e = scan.nextInt();
		dist = new int[n + 1][n + 1];
		list = new ArrayList[n + 1];
		for (int i = 0; i < list.length; i++)
			list[i] = new ArrayList<Node>();
		for (int i = 0; i < e; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}

		v1 = scan.nextInt();
		v2 = scan.nextInt();

		dijkstra(1, n, 1);
		dijkstra(v1, n, v1);
		dijkstra(v2, n, v2);
		int answer = Math.min(dist[1][v1] + dist[v1][v2] + dist[v2][n], dist[1][v2] + dist[v2][v1] + dist[v1][n]);
		if (answer >= INF) {
			System.out.println("-1");
		} else {
			System.out.println(answer);
		}
	}

	public void dijkstra(int start, int n, int idx) {
		Arrays.fill(dist[idx], INF);
		boolean visited[] = new boolean[n + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>((node1, node2) -> {
			return node1.w - node2.w;
		});

		dist[idx][start] = 0;
		pq.offer(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (visited[curr.v])
				continue;

			visited[curr.v] = true;

			for (Node next : list[curr.v]) {
				if (dist[idx][next.v] > dist[idx][curr.v] + next.w) {
					dist[idx][next.v] = dist[idx][curr.v] + next.w;
					pq.offer(new Node(next.v, dist[idx][next.v]));
				}
			}
		}
	}

	class Node {
		int v;
		int w;
		boolean visited1;
		boolean visited2;

		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Node [v=" + v + ", w=" + w + ", visited1=" + visited1 + ", visited2=" + visited2 + "]";
		}

	}
}