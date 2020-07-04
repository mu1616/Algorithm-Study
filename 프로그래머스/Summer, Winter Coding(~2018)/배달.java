import java.util.*;
class Solution {
	int graph[][];
	int dist[];
	int townCnt;
    
    public int solution(int n, int[][] road, int k) {
        int answer = 0;
        graph = new int[n][n];
        dist = new int[n];
        townCnt = n;
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int i = 0; i< road.length; i++) {
        	if(graph[road[i][0] - 1][road[i][1] - 1] == 0) {
        		graph[road[i][0] - 1][road[i][1] - 1] = road[i][2];        
        		graph[road[i][1] - 1][road[i][0] - 1] = road[i][2];
        		
        	} else {
        		if(graph[road[i][0] - 1][road[i][1] - 1] > road[i][2]) {
        			graph[road[i][0] - 1][road[i][1] - 1] = road[i][2];
        			graph[road[i][1] - 1][road[i][0] - 1] = road[i][2];
        		}
        	}
        }
        
        bfs();
        
        for(int i=0; i< dist.length; i++) {
        	if(dist[i] <= k)
                answer++;
        }

        	

        return answer;
    }
    
    public void bfs() {
    	Queue<Integer> queue = new LinkedList<>();
    	queue.offer(0);
    	dist[0] = 0;
    	
    	while(!queue.isEmpty()) {
    		int curr = queue.poll();

    		for(int i = 0; i < townCnt; i++) {
    			if(graph[curr][i] != 0) {
	    			int distSum = dist[curr] + graph[curr][i];
	
	    			if(dist[i] > distSum) {
	    				dist[i] = distSum;
	    				queue.add(i);
	    			}
    			}
    		}
    	}
    }
}