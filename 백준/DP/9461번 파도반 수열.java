import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		Main main = new Main();
		int t = scan.nextInt();
		for(int i = 0; i < t; i++)
			main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		long dp[] = new long[n + 1];
		
		for(int i = 1; i < n + 1; i++) {
			if(i == 1) dp[i] = 1;
			if(i == 2) dp[i] = 1;
			if(i == 3) dp[i] = 1;
			if(i == 4) dp[i] = 2;
			if(i == 5) dp[i] = 2;
			
			if(i >= 6) dp[i] = dp[i - 1] + dp[i - 5];		
		}
		
		System.out.println(dp[n]);
	}
}

