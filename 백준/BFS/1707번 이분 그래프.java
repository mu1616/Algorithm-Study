package algorithm;

import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	ArrayList<Integer> graph[];
	boolean visited[];
	HashSet<Integer> set1 = new HashSet<>();
	HashSet<Integer> set2 = new HashSet<>();
	
	public static void main(String[] args) {
		Main main = new Main();
		int k = scan.nextInt();
		for (int i = 0; i < k; i++)
			main.solution();
	}

	public void solution() {
		int v = scan.nextInt();
		int e = scan.nextInt();
		visited = new boolean[v];
		graph = new ArrayList[v];
		set1.clear();
		set2.clear();
		for(int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();
		
		for(int i = 0; i < e; i++) {
			int x = scan.nextInt() - 1;
			int y = scan.nextInt() - 1;
			graph[x].add(y);
			graph[y].add(x);
		}
		
		for(int i = 0; i < v; i++) {
			if(!visited[i]) {
				boolean isSuccess = bfs(i);
				if(!isSuccess) {
					System.out.println("NO");
					return;
				}
			}
		}
		
		System.out.println("YES");
	}
	
	public boolean bfs(int start) {
		boolean isSuccess = true;
		Queue<Integer> queue = new LinkedList<>();
		set1.add(start);
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			visited[curr] = true;
			
			for(int i = 0; i < graph[curr].size(); i++) {
				int next = graph[curr].get(i);
				if(!visited[next]) {
					queue.offer(next);

					if (set1.contains(curr)) {
						if (set1.contains(next)) {
							isSuccess = false;
						} else {
							set2.add(next);
						}
					} else {
						if (set2.contains(next)) {
							isSuccess = false;
						} else {
							set1.add(next);
						}
					}
				}
			}
		}
		
		return isSuccess;
	}
}