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
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) arr[i] = scan.nextInt();
		
		int dp[] = new int[n];
		dp[0] = 1;
		
		for(int i = 1; i< n; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[i] < arr[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		Arrays.sort(dp);
		System.out.println(dp[dp.length - 1]);
	}
}