import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		long dp[] = new long[n+1];   
		long zeroCount[] = new long[n+1];
		dp[1] = 1;
		zeroCount[1] = 0;
		
		for(int i=2; i< n+1; i++) {
			dp[i] = dp[i-1] + zeroCount[i-1];
			zeroCount[i] = dp[i-1];
		}
		System.out.println(dp[n]);
		
	}

}