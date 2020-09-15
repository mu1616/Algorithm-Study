import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
    
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}
	
    public void solution() {
    	int n = scan.nextInt();
    	int m = scan.nextInt();
    	int map[][] = new int[n][m];
    	
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			map[i][j] = scan.nextInt();
    		}
    	}
    	
    	int dp[][] = new int[n][m];
    	
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			if(i == 0 && j == 0) {
    				dp[i][j] = map[i][j];
    				continue;
    			}
    			
    			if(i == 0) {
    				dp[i][j] = dp[i][j - 1] + map[i][j];
    				continue;
    			}
    			
    			if(j == 0) {
    				dp[i][j] = dp[i - 1][j] + map[i][j];
    				continue;
    			}
    			
    			dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i][j - 1])) + map[i][j];
    		}
    	}
 
    	System.out.println(dp[n - 1][m - 1]);
    }
}
