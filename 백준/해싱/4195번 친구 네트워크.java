import java.math.BigInteger;
import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	HashMap<String, Integer> map;
	int parent[];
	int level[];
	int relation[];
	StringBuffer sb = new StringBuffer();
	public static void main(String[] args) {
		Main main = new Main();
		int k = scan.nextInt();
		for (int i = 0; i < k; i++)
			main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		//해쉬맵은 해당 스트링의 인덱스를 알기위해서 사용한다!!!!
		map = new HashMap<>();
        parent = new int[200001];
        level = new int[200001];
        relation = new int[200001];
        
        for(int i=0; i< 200001; i++) {
        	parent[i] = i;
        	relation[i] = 1;
        }
        
        int idx = 1;
		for (int i = 0; i < n; i++) {
			String name1 = scan.next();
			String name2 = scan.next();
			
			if(!map.containsKey(name1))
				map.put(name1, idx++);
			if(!map.containsKey(name2))
				map.put(name2, idx++);
			
			int u = map.get(name1);
			int v = map.get(name2);
			
			union(u, v);		
		}
	}
	
	public void union(int u, int v) {
		u = find(u);
		v = find(v);
		
		if(u==v) {
		  System.out.println(relation[u]);
		  return;
		}
		
		if(level[u] > level[v]) {
			int temp = u;
			u = v;
			u = temp;
		}
		parent[u] = v;
		relation[v] += relation[u];
		System.out.println(relation[v]);
		
		if(level[u] == level[v])
			level[v]++;
	}
	
	public int find(int u) {
		if(u == parent[u])
			return u;
		
		return parent[u] = find(parent[u]);
		
	}
	
}