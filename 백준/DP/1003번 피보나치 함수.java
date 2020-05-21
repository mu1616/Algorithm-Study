import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Main main = new Main();
		int t = scan.nextInt();
		for(int i=0; i< t; i++) {
			main.solution(scan.nextInt());
		}
		
	}

	public void solution(int n) {
		int dp1[] = new int[n+1];
		int dp2[] = new int[n+1];
		dp1[0] = 1;
		dp2[0] = 0;
		if(n>=1) {
			dp1[1] = 0;
			dp2[1] = 1;
		}
		for(int i=2; i< dp1.length; i++) {
			dp1[i] = dp1[i-1] + dp1[i-2];
			dp2[i] = dp2[i-1] + dp2[i-2];
		}
		System.out.println(dp1[n]+" "+dp2[n]);
		
	}

}