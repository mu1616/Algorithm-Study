//dfs,bfs 문제지만 disjoin-set이 떠올라서 disjoin-set으로 품
import java.util.*;
class Solution {
    int parent[];
	int rank[];
	public int solution(int n, int[][] computers) {
        int answer = 0;
        parent = new int[computers.length];
        rank = new int[computers.length];
        
        for(int i=0; i< n; i++)
        	parent[i] = i;
        for(int i=0; i< computers.length; i++) {
        	for(int j=0; j< computers[0].length; j++) {
        		if(computers[i][j] == 1) {
        			union(i, j);
        		}
        	}
        }
        
        HashSet<Integer> network = new HashSet<>();
        for(int i=0; i< n; i++) {
        	network.add(find(i));
        }
        
        answer = network.size();
        
        return answer;
    }
	
	public int find(int u) {
		if(u == parent[u])
			return u;
		
		return parent[u] = find(parent[u]);
	}
	
	public void union(int u, int v) {
		u = find(u);
		v = find(v);
		
		if(u == v) 
			return;
		
		if(rank[u] > rank[v]) {
			int tmp = u;
			u = v;
			v = tmp;
		}
		
		parent[u] = v;
		
		if(rank[u] == rank[v]) 
			rank[v]++;
	}
		
}