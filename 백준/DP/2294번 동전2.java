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
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) arr[i] = scan.nextInt();
		int dp[] = new int[100000];
        
        for(int i = 2; i <= k; i++) {
        	int min = Integer.MAX_VALUE;
        	
        	for(int j = 0; j < arr.length; j++) {
        		if(i == arr[j]) {
        			min = 1;
        			break;
        		}
        		
        		if(i - arr[j] > 0 && dp[i - arr[j]] > 0)
        			min = Math.min(min, dp[i - arr[j]] + 1);
        	}
        	
        	if(min == Integer.MAX_VALUE)
        		dp[i] = -1;
        	else
        		dp[i] = min;
        }
        
        
        System.out.println(dp[k]);
	}
}