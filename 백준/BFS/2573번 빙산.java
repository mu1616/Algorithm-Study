import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int map[][];
	int dx[] = {1, -1, 0, 0};
	int dy[] = {0, 0, 1, -1};
	boolean visited[][];
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

    public void solution() {
    	int n = scan.nextInt();
    	int m = scan.nextInt();
    	map = new int[n][m];
    	
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			map[i][j] = scan.nextInt();
    		}
    	}
    	
    	int cnt = 0;
    	while(true) {
    		visited = new boolean[n][m];
    		int ice = 0;
    		for(int i = 0; i < map.length; i++) {
    			for(int j = 0; j < map[0].length; j++) {
    				if(map[i][j] != 0 && !visited[i][j]) {
    					ice++;
    					bfs(j, i);
    				}
    			}
    		}
    		
    		if(ice >= 2) {
    			break;
    		}
    		
    		if(ice == 0) {
    			System.out.println("0");
    			return;
    		}
    		
    		cnt++;
    		passTime();
    	}
    	
    	System.out.println(cnt);  	
    }
    
    public void bfs(int x, int y) {
    	Queue<Node> queue = new LinkedList<>();
    	visited[y][x] = true;
    	queue.offer(new Node(x, y));
    	
    	while(!queue.isEmpty()) {
    		Node curr = queue.poll();
    		
    		for(int i = 0; i < 4; i++) {
    			int nx = curr.x + dx[i];
    			int ny = curr.y + dy[i];
    			
    			if(nx >=0 && nx < map[0].length && ny >=0 && ny < map.length) {
    				if(map[ny][nx] != 0 && !visited[ny][nx]) {
    					visited[ny][nx] = true;
    					queue.offer(new Node(nx, ny));
    				}
    			}
    		}
    	}
    }
    
    public void passTime() {
    	int cachedMap[][] = new int[map.length][map[0].length];
    	for(int i = 0; i < map.length; i++) {
    		for(int j = 0; j< map[0].length; j++) {
    			cachedMap[i][j] = map[i][j];
    		}
    	}
    	
    	for(int i = 0; i < map.length; i++) {
    		int y = i;
    		for(int j = 0; j < map[0].length; j++) {
    			int x = j;
    			if(map[y][x] == 0) continue;
    			
    			for(int k = 0; k < 4; k++) {
    				int nx = x + dx[k];
    				int ny = y + dy[k];
    				
    				if(nx >= 0 && nx < map[0].length && ny >= 0 && ny < map.length) { 
    					if(cachedMap[ny][nx] == 0) {
    						map[y][x] -= 1;
    					}
    				}
    				
    				if(map[y][x] == 0) break;
    			}
    		}
    	}
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