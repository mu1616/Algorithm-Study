import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		int t = scan.nextInt();
		for (int i = 0; i < t; i++)
			main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int arr[][] = new int[2][n + 1];
		for (int i = 1; i < n + 1; i++)
			arr[0][i] = scan.nextInt();
		for (int i = 1; i < n + 1; i++)
			arr[1][i] = scan.nextInt();

		int dp[][] = new int[2][n + 1];
		int choice = -1;
		for (int i = 1; i < n + 1; i++) {
			if(i == 1) {
				dp[0][i] = arr[0][i];
				dp[1][i] = arr[1][i];
				
			} else {
				dp[0][i] = Math.max((dp[1][i - 1] + arr[0][i]), (dp[1][i - 2] + arr[0][i]));
				dp[0][i] = Math.max(dp[0][i], dp[0][i - 2] + arr[0][i]);
				dp[1][i] = Math.max((dp[0][i - 1] + arr[1][i]), (dp[0][i - 2] + arr[1][i]));
				dp[1][i] = Math.max(dp[1][i], dp[1][i - 2] + arr[1][i]);
			}

		}
		
		System.out.println(Math.max(dp[0][n], dp[1][n]));
	}
}