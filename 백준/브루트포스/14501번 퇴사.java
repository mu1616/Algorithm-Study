import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		int n = scan.nextInt();
		int t[] = new int[n];
		int p[] = new int[n];
		for(int i=0; i< n; i++) {
			t[i] = scan.nextInt();
			p[i] = scan.nextInt();
		}
		System.out.println(m.recursion(t,p,0));
		
	}
	
	public int recursion(int []t, int []p, int start) {
		if(start==t.length) //베이스 케이스
			return 0;
		if(start + t[start] > t.length) {  //t[i]를 수행하면 퇴사날짜를 넘겨버릴때
			int without = recursion(t,p,start+1);
			return without;
		}else {
			int with = p[start] + recursion(t, p, start+t[start]);
			int without = recursion(t,p,start+1);
			int result = with>without?with:without;
			return result;
		}
	}
}