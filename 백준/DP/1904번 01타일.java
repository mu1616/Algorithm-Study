import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int dp[] = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			if(i == 1) dp[i] = 1;
			else if(i == 2) dp[i] = 2;
			else dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
		}
		
		System.out.println(dp[n]);
	}
}