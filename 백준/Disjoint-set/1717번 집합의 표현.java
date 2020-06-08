import java.math.BigInteger;
import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int parent[];
	int rank[];
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		parent = new int[n+1];
		rank = new int[n+1];
		for(int i=0; i< n+1; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		int m = scan.nextInt();
		for(int i=0; i< m; i++) {
			int op = scan.nextInt();
			int n1 = scan.nextInt();
			int n2 = scan.nextInt();
			if(op == 0) {
				union(n1, n2);
			}
			else {
				if(find(n1) == find(n2)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}
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