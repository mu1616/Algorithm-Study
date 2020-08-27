import java.util.*;

class Solution {
    boolean graph[][];
	int dx[] = {1, 0, -1, 0};
	int dy[] = {0, 1, 0, -1};
    
    public int solution(int[][] board) {
        int answer = 0;
        graph = new boolean[board.length*board.length][board.length*board.length];
        
        answer = bfs(board);
        return answer;
    }
    
    public int bfs(int board[][]) {
    	Queue<Robot> queue = new LinkedList<>();
    	queue.offer(new Robot());
    	graph[0][1] = true;
    	graph[1][0] = true;
    	
    	while(!queue.isEmpty()) {
    		Robot curr = queue.poll();
    		
    		for(int i = 0; i < 4; i++) {
    			int leftX = curr.left % board.length + dx[i];
    			int leftY = curr.left / board.length + dy[i];
    			int rightX = curr.right % board.length + dx[i];
    			int rightY = curr.right / board.length + dy[i];
    			
    			if(leftX >=0 && leftX < board.length && leftY >=0 && leftY < board.length &&
    					rightX >=0 && rightX < board.length && rightY >=0 && rightY < board.length) {
    				if(board[leftY][leftX] == 0 && board[rightY][rightX] == 0) {
    					Robot robot = new Robot();
    					robot.left = leftY * board.length + leftX;
    					robot.right = rightY * board.length + rightX;
    					robot.ld = curr.ld;
    					robot.rd = curr.rd;
    					robot.timer = curr.timer + 1;
    					
    					if(robot.left == board.length * board.length - 1 || robot.right == board.length * board.length - 1) {
    						return robot.timer;
    					}
    					
    					if(!graph[robot.left][robot.right]) {
	    					queue.offer(robot);
	    					graph[robot.left][robot.right] = true; 
    					}
    				}
    			}
    		}
    		
    		//시계방향
    		
    		for(int i = 0; i < 2; i++) {
    			if(i == 1) {
    				int tmp = curr.left;
    				curr.left = curr.right;
    				curr.right = tmp;
    				curr.rd = (curr.rd + 2) % 4;
    			}
        		int d = (curr.rd + 1) % 4;
				int leftX = curr.left % board.length;
				int leftY = curr.left / board.length;
				int rightX = curr.right % board.length;
				int rightY = curr.right / board.length;
				
				if(rightX + dx[d] >= 0 && rightX + dx[d] < board.length && board[rightY][rightX + dx[d]] == 0) {
					if(rightY + dy[d] >=0 && rightY + dy[d] < board.length && board[rightY + dy[d]][rightX] == 0) {

						if(board[leftY + dy[d]][leftX + dx[d]] == 0) {

							Robot robot = new Robot();
							robot.left = curr.left;
							robot.right = (leftY + dy[d]) * board.length + leftX + dx[d];
							robot.rd = d;
							robot.timer = curr.timer + 1;

	    					if(robot.left == board.length * board.length - 1 || robot.right == board.length * board.length - 1) {
	    						return robot.timer;
	    					}

	    					if(!graph[robot.left][robot.right]) {
		    					queue.offer(robot);
		    					graph[robot.left][robot.right] = true; 
	    					}
						}
					}
				}
    		}
    		
    		//반시계		
    		for(int i = 0; i < 2; i++) {
    			if(i == 1) {
    				int tmp = curr.left;
    				curr.left = curr.right;
    				curr.right = tmp;
    				curr.rd = (curr.rd + 2) % 4;
    			}
        		int d = (curr.rd - 1 >= 0) ? (curr.rd - 1) : 3;
				int leftX = curr.left % board.length;
				int leftY = curr.left / board.length;
				int rightX = curr.right % board.length;
				int rightY = curr.right / board.length;
				
				if(rightX + dx[d] >= 0 && rightX + dx[d] < board.length && board[rightY][rightX + dx[d]] == 0) {
					if(rightY + dy[d] >=0 && rightY + dy[d] < board.length && board[rightY + dy[d]][rightX] == 0) {

						if(board[leftY + dy[d]][leftX + dx[d]] == 0) {

							Robot robot = new Robot();
							robot.left = curr.left;
							robot.right = (leftY + dy[d]) * board.length + leftX + dx[d];
							robot.rd = d;
							robot.timer = curr.timer + 1;

	    					if(robot.left == board.length * board.length - 1 || robot.right == board.length * board.length - 1) {
	    						return robot.timer;
	    					}

	    					if(!graph[robot.left][robot.right]) {
		    					queue.offer(robot);
		    					graph[robot.left][robot.right] = true; 
	    					}
						}
					}
				}
    		}
    		
    	}
    	
    	return 0;
    }
    

    class Robot {
    	int left = 0;
    	int right = 1;
    	int ld = 2;
    	int rd = 0;
    	int timer = 0;
    	
		@Override
		public String toString() {
			return "Robot [left=" + left + ", right=" + right + ", ld=" + ld + ", rd=" + rd + ", timer=" + timer + "]";
		}
    	
    	
    }
}