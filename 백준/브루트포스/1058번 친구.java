import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
   	int graph[][];
   	int cnt = 0;
   	boolean visited[];
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

    public void solution() {
    	int n = scan.nextInt();
    	graph = new int[n][n];
    	for(int i = 0; i < n; i++) {
    		String str = scan.next();
    		for(int j = 0; j < n; j++) {
    			char a = str.charAt(j);
    			if(a == 'Y') {
    				graph[i][j] = 1;
    			}
    		}
    	}
    	
    	int max = Integer.MIN_VALUE;
    	for(int i = 0; i < n; i++) {
        	int cnt = bfs(i, n);
    		if(max < cnt) max = cnt;
    	}
    	
    	System.out.println(max);
    }
    
    public int bfs(int start, int n) {
    	int cnt = 0;
    	boolean visited[] = new boolean[n];
    	visited[start] = true;
    	Queue<Node> queue = new LinkedList<>();
    	queue.offer(new Node(start, 0));
    	
    	while(!queue.isEmpty()) {
    		Node curr = queue.poll();
    		if(curr.depth == 2) continue;
    		
    		for(int i = 0; i < n; i++) {
    			if(!visited[i] && graph[curr.index][i] == 1) {
    				cnt++;
    				queue.offer(new Node(i, curr.depth + 1));
    				visited[i] = true;
    			}
    		}
    	}
    	return cnt;
    }
    
    class Node {
    	int index;
    	int depth;
    	Node(int index, int depth) {
    		this.index = index;
    		this.depth = depth;
    	}
    }
}