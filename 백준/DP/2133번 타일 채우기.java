package algorithm;

import java.util.*;
import java.util.stream.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		long dp[] = new long[n + 1];

		for (int i = 1; i <= n; i++) {
			if (i % 2 != 0) {
				dp[i] = 0;
				continue;
			}
			
			if (i == 2) {
				dp[i] = 3;
				continue;
			}

			if (i == 4) {
				dp[i] = 11;
				continue;
			}
			
			dp[i] = (3 * dp[i - 2]) + (2 * dp[i - 4]) + (dp[i - 2] - (dp[i - 4] * 3));

		}
		System.out.println(dp[n]);
	}

}