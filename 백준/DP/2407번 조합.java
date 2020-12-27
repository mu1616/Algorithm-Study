import java.math.BigInteger;
import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int m = scan.nextInt();
		BigInteger dp[][] = new BigInteger[n + 1][n + 1];
		dp[1][0] = BigInteger.ONE;
		
		for(int i = 1; i < n + 1; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0) {
					dp[i][j] = BigInteger.ONE;
					continue;
				}
				if(i == j) {
					dp[i][j] = BigInteger.ONE;
					continue;
				}
				dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
			}
		}
		
		System.out.println(dp[n][m]);
	}
}