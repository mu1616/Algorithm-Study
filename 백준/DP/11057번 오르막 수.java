import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

    public void solution() {
        int n = scan.nextInt();
        int dp[][] = new int[n + 1][10];
        for(int i = 0; i < 10; i++) dp[1][i] = 1;
        
        for(int i = 2; i < n + 1; i++) {
        	dp[i][0] = dp[i - 1][0] % 10007;
        	for(int j = 1; j < 10; j++) {
        		dp[i][j] = dp[i][j - 1] + dp[i - 1][j] % 10007;
        	}
        }
        
        int sum = 0;
        for(int i = 0; i < 10; i++) sum+= dp[n][i];
        
        System.out.println(sum % 10007);
    }
}