import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

    public void solution() {
    	int n = scan.nextInt();
    	int m = scan.nextInt();
    	int graph[][] = new int[n + 1][n + 1];
    	for(int i = 0; i < m; i++) {
    		int x = scan.nextInt();
    		int y = scan.nextInt();
    		graph[x][y] = 1;
    		graph[y][x] = 1;
    	}
    	
    	int min = Integer.MAX_VALUE;
    	int answer = 0;
    	for(int i = 1; i <= n; i++) {
    		int kb = bfs(i, n, graph);
    		if(min > kb) {
    			min = kb;
    			answer = i;
    		}
    	}
    	
    	System.out.println(answer);
    	
    }
    
    public int bfs(int node, int n, int graph[][]) {
    	boolean visited[] = new boolean[n + 1];
    	int dist[] = new int[n + 1];
    	Queue<Integer> queue = new LinkedList<>();
    	dist[node] = 0;
    	visited[node] = true;
    	queue.offer(node);
    	
    	while(!queue.isEmpty()) {
    		int curr = queue.poll();
    		
    		for(int i = 1; i <= n; i++) {
    			if(!visited[i] && graph[curr][i] == 1) {
    				dist[i] = dist[curr] + 1;
    				visited[i] = true;
    				queue.offer(i);
    			}
    		}
    	}
    	
    	int sum = 0;
    	for(int i : dist) sum += i;
    	
    	return sum;
    }
}