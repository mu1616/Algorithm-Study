class Solution {
    boolean visited[][];
	int dx[] = {0, 1, 1};
	int dy[] = {1, 0, 1};
	int result;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char array[][] = new char[m][n];
        visited = new boolean[m][n];
        for(int i=0; i< m; i++) {
        	for(int j=0; j< n; j++) {
        		array[i][j] = board[i].charAt(j);
        	}
        }
        
        while(true) {
        	initVisited();
        	
	        for(int i=0; i< m-1; i++) {
	        	for(int j=0; j< n-1; j++) {
	        		detectBlock(array, j, i);
	        	}
	        }
	        
	        int sum = 0;
	        for(int i=0; i< array.length; i++) {
	    		for(int j=0; j< array[0].length; j++) {
	    			if(visited[i][j]) {
	    				sum++;
	    				array[i][j] = '0';
	    			}
	    		}
	    	}
	        
	        if(sum == 0)
	        	break;
	        else
	        	result += sum;
	        
	        for(int i = m-1; i>=0; i--) {
	        	for(int j=0; j< n; j++) {
	        		downBlock(array, j, i);
	        	}
	        }
        }
     
        answer = result;
        return answer;
    }
     
    public void detectBlock(char array[][], int x, int y) {
    	char a = array[y][x];
    	
    	if(a == '0')
    		return;
    	
    	for(int i=0; i< 3; i++) {
    		int cx = x + dx[i];
    		int cy = y + dy[i];
    		
    		if(a != array[cy][cx]) {
    			return;
    		}
    	}
    	
    	visited[y][x] = true;
    	for(int i=0; i< 3; i++) {
    		int cx = x + dx[i];
    		int cy = y + dy[i];
    		visited[cy][cx] = true;
    	}
    	
    }
    
    public void downBlock(char array[][], int x, int y) {
    	if(y + 1 == array.length || array[y+1][x] != '0' || array[y][x] == '0') {
    		return;
    		
    	} else {
    		array[y+1][x] = array[y][x];
    		array[y][x] = '0';
    		downBlock(array, x, y+1);
    	}
    }
    
    public void initVisited() {
    	for(int i=0; i< visited.length; i++) {
    		for(int j=0; j< visited[0].length; j++) {
    			visited[i][j] = false;
    		}
    	}
    }
}
