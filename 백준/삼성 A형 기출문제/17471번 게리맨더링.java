/*
 * 1. 조합 알고리즘을 이용해 두 팀으로 나눈다.
 * 2. bfs를 이용해 같은 팀임과 동시에 인접한 노드를 탐색한다. (팀1, 팀2 총 2번 bfs 탐색)
 * 3. 모든 노드가 방문되었다면 사람수의 차이를 계산한다. 방문되지 않은 노드가 있다면 return 
 * 4. 반복
*/
import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int graph[][];
	int min = 10000;
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		Node nodes[] = new Node[n];
		graph = new int[n][n];
		
		for(int i=0; i< n; i++)
			nodes[i] = new Node(i, scan.nextInt(), 0);
		
		for(int i=0; i< n; i++) {
			int cnt = scan.nextInt();
			
			for(int j=0; j< cnt; j++) {
				graph[i][scan.nextInt()-1] = 1;
			}	
		}
		
		
		for(int i=1; i<= n/2; i++) {
			combi(nodes, 0, i);
		}
		
		if(min == 10000) {
			System.out.println("-1");
		} else {
			System.out.println(min);
		}
		
		
	}
	
	public void combi(Node[] nodes, int start, int r) {
		if(r == 0) {
			boolean visited[] = new boolean[nodes.length];
			int cnt1 = 0;
			int cnt2 = 0;
			
			for(Node node : nodes) 
				if(node.team == 0) {
					cnt1 = bfs(nodes, node, visited);
					break;
				}
				
			for(Node node : nodes) 
				if(node.team == 1) {
					cnt2 = bfs(nodes, node, visited);
					break;
				}
			
			for(int i = 0; i< visited.length; i++) {
				if(visited[i] == false)
					return;
			}
			
			int result = Math.abs(cnt1 - cnt2);
			
			if(min > result)
				min = result;

		} else {
			for(int i = start; i < nodes.length; i++) {
				nodes[i].team = 1;
				combi(nodes, i + 1, r - 1);
				nodes[i].team = 0;
			}
		}
	}
	
	public int bfs(Node[] nodes, Node node, boolean visited[]) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(node);
		visited[node.idx] = true;
		int peopleCount = node.people;
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			
			for(int i = 0; i < nodes.length; i++) {
				if(!visited[nodes[i].idx] && graph[curr.idx][nodes[i].idx] == 1 &&  curr.team == nodes[i].team) {
					visited[nodes[i].idx] = true;
					queue.offer(nodes[i]);
					peopleCount += nodes[i].people;
				}
			}
		}
		
		return peopleCount;
	}
	
	class Node {
		int idx;
		int people;
		int team;
		Node (int idx, int people, int team) {
			this.idx = idx;
			this.people = people;
			this.team = team;
		}
	}
}
