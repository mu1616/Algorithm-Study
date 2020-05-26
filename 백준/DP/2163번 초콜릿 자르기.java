import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		m.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int m = scan.nextInt();
		int dp[][] = new int[n+1][m+1];
		for(int i=1; i< n+1; i++) {
			for(int j=1; j< m+1; j++) {
				if(i==1 && j==1) dp[i][j] = 0;
				else if(i==1) dp[i][j] = j-1;
				else if(j==1) dp[i][j] = i-1;
				else dp[i][j] = dp[i-1][j] + j;
			}
		}
		System.out.println(dp[n][m]);
	}



}