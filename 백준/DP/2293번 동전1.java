import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

    public void solution() {
    	int n = scan.nextInt();
    	int k = scan.nextInt();
    	int coins[] = new int[n];
    	for(int i = 0; i < n; i++) coins[i] = scan.nextInt();
    	Arrays.sort(coins);
    	
    	int dp[] = new int[k + 1];
    	
    	for(int i = 0; i < n; i++) {
    		for(int j = 1; j < k + 1; j++) {
    			int coin = coins[i];
    			if(coin == j) {
    				dp[j] += dp[j - coin] + 1;
    			} else if(j - coin > 0) {
    				dp[j] += dp[j - coin];
    			}
    		}
    	}
    	
    	System.out.println(dp[k]);
    }
}