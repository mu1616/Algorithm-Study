import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int dp[][] = new int[n + 1][3];
		dp[1][0] = 1;
		dp[1][1] = 1;
		dp[1][2] = 1;
		
		for (int i = 2; i <= n; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
			dp[i][1] = (dp[i -1][0] + dp[i - 1][2]) % 9901;
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
		}
		
		System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % 9901);
	}
	

}
