import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int dp[][] = new int[n+1][10];
		for(int i=1; i< 10; i++) {
			dp[1][i] = 1;
		}
		
		for(int i=2; i<= n; i++) {
			for(int j=0; j< 10; j++) {
				if(j == 0) {
					dp[i][j+1] = (dp[i][j+1] + dp[i-1][j])%1000000000;
				} else if(j == 9) {
					dp[i][j-1] = (dp[i][j-1] + dp[i-1][j])%1000000000;
				} else {
					dp[i][j-1] = (dp[i][j-1] + dp[i-1][j])%1000000000;
					dp[i][j+1] = (dp[i][j+1] + dp[i-1][j])%1000000000;
				}
			}
		}
		
		int sum = 0;
		for(int i=0; i< 10; i++)
			sum = (sum + dp[n][i])%1000000000;
		
		System.out.println(sum);
	}

}