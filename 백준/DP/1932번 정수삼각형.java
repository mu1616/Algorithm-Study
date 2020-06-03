import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int array[][] = new int[n][n];
		for(int i=0; i< n; i++) {
			for(int j=0; j< i+1; j++) {
				array[i][j] = scan.nextInt();
			}
		}
		int dp[][] = new int[n][n];
		dp[0][0] = array[0][0];
		for(int i=1; i< n; i++) {
			for(int j=0; j< i+1; j++) {
				if(j==0) {
					dp[i][j] = dp[i-1][0] + array[i][j];
				}
				else if(j == i) {
					dp[i][j] = dp[i-1][i-1] + array[i][j];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + array[i][j];
				}
			}
		}
		Arrays.sort(dp[n-1]);
		System.out.println(dp[n-1][n-1]);
	}

}