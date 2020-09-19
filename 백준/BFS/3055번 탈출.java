import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
    int dx[] = {1, -1, 0, 0};
    int dy[] = {0, 0, 1, -1};
    boolean visited1[][];
    boolean visited2[][];
    
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}
	
    public void solution()  {
    	int r = scan.nextInt();
    	int c = scan.nextInt();
    	char map[][] = new char[r][c];
    	for(int i = 0; i < r; i++) {
    		String str = scan.next();
    		for(int j = 0; j < c; j++) {
    			map[i][j] = str.charAt(j);
    		}
    	}
    	visited1 = new boolean[r][c];
    	visited2 = new boolean[r][c];
    	int result = bfs(map);
    	if(result == -1) {
    		System.out.println("KAKTUS");
    	} else {
        	System.out.println(result);
    	}
    	
    }
    
    public int bfs(char map[][]) {
    	Queue<Node> queue = new LinkedList<>();
    	for(int i = 0; i < map.length; i++) {
    		for(int j = 0; j < map[0].length; j++) {
    			if(map[i][j] == '*')
    				queue.offer(new Node(j, i, map[i][j]));
    		}
    	}
    	
    	for(int i = 0; i < map.length; i++) {
    		for(int j = 0; j < map[0].length; j++) {
    			if(map[i][j] == 'S')
    				queue.offer(new Node(j, i, map[i][j]));
    		}
    	}

    	while(!queue.isEmpty()) {
    		Node curr = queue.poll();
    		
    		for(int i = 0; i < 4; i++) {
    			int nx = curr.x + dx[i];
    			int ny = curr.y + dy[i];
    			
    			if(curr.c == '*') {
    				if(nx >=0 && nx < map[0].length && ny >=0 && ny < map.length) {
    					if(!visited1[ny][nx] && map[ny][nx] != 'D' && map[ny][nx] != 'X') {
    						visited1[ny][nx] = true;
    						queue.offer(new Node(nx, ny, '*'));
    					}
    				}
    			}
    			
    			if(curr.c == 'S') {
    				if(nx >=0 && nx < map[0].length && ny >=0 && ny < map.length) {
    					if(!visited1[ny][nx] && map[ny][nx] != 'X' && !visited2[ny][nx]) {
    						if(map[ny][nx] == 'D') return curr.cnt + 1;
    						visited2[ny][nx] = true;
    						Node node = new Node(nx, ny, 'S');
    						node.cnt = curr.cnt + 1;
    						queue.offer(node);
    					}
    				}
    			}
    			
    		}
    	}
    	
    	return -1;
    }
    
    class Node {
    	int x;
    	int y;
    	char c;
    	int cnt = 0;
    	Node(int x, int y, char c) {
    		this.x = x;
    		this.y = y;
    		this.c = c;
    	}
    }
}