import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int k = 1;
		int dp[] = new int[n + 1];
		dp[1] = 1;

		for (int i = 2; i < n + 1; i++) {
			for (int j = 1; j * j <= i; j++) {
				if (dp[i] > dp[i - j * j] + 1 || dp[i] == 0) {
					dp[i] = dp[i - j * j] + 1;
				}
			}
		}

		System.out.println(dp[n]);
	}

}
