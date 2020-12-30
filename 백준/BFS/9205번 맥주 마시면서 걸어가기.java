import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		int t = scan.nextInt();
		for (int i = 0; i < t; i++)
			main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		Node house = new Node(scan.nextInt(), scan.nextInt());
		Node stores[] = new Node[n];
		for(int i = 0; i < n; i++) 
			stores[i] = new Node(scan.nextInt(), scan.nextInt());
		Node festival = new Node(scan.nextInt(), scan.nextInt());
		
		boolean possible = bfs(house, festival, stores);
		
		System.out.println(possible ? "happy" : "sad");
	}
	
	public boolean bfs(Node house ,Node festival, Node stores[]) {
		boolean possible = false;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(house);
		HashSet<Node> visitedSet = new HashSet<>();
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			
			if (Math.abs(curr.x - festival.x) + Math.abs(curr.y - festival.y) <= 1000) {
				possible = true;
				break;
			}
			
			for(Node next : stores) {
				if (!visitedSet.contains(next) && Math.abs(curr.x - next.x) + Math.abs(curr.y - next.y) <= 1000) {
					visitedSet.add(next);
					queue.offer(next);
				}
			}
		}
		return possible;
	}
	
	class Node {
		int x;
		int y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
