import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
		
	}

	public void solution() {
		int n = scan.nextInt();
		int dp[] = new int[n+1];
		dp[1] = 0;
		if(n>=2)
			dp[2] = 1;
		if(n>=3)
			dp[3] = 1;
		for(int i=4; i< dp.length; i++) {
			if(i%2==0 && i%3==0) {
				dp[i] = Math.min(dp[i/3],Math.max(dp[i-1], dp[i/2])) + 1;
			}else if(i%2==0) {
				dp[i] = Math.min(dp[i-1], dp[i/2]) + 1;
			}else if(i%3==0) {
				dp[i] = Math.min(dp[i-1], dp[i/3]) + 1;
			}else {
				dp[i] = dp[i-1] + 1;
			}
		}
		System.out.println(dp[n]);
	}

}