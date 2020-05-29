import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int visited[][];
	public static void main(String[] args) {
		Main m = new Main();
		m.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int dp[] = new int[n+1];
		
		for(int i=1; i< n+1; i++) {
			if(i==1) dp[1] = 1;
			else if(i==2) dp[2] = 2;
			else if(i==3) dp[3] = 3;
			else if(i%2==0) {
				dp[i] = (dp[i/2]*dp[i/2] + dp[i/2-1]*dp[i/2-1])%10007;
			}else {
				dp[i] = (dp[i/2]*dp[i/2+1] + dp[i/2-1]*dp[i/2])%10007;
			}
			
		}
		System.out.println(dp[n]);
	}
	

}