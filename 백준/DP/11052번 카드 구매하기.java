import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int p[] = new int[n+1];
		
		for(int i=1; i<= n; i++)
			p[i] = scan.nextInt();
		
		int dp[] = new int[n+1];
		dp[1] = p[1];
		
		for(int i=2; i<= n; i++) {
			dp[i] = p[i];
			for(int j = 1; j<= i/2; j++) {
				dp[i] = Math.max(dp[j] + dp[i-j], dp[i]);
			}
		}
		
		System.out.println(dp[n]);
	}
    

}