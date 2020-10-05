import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int arr[] = new int[n + 1];
		for(int i = 1; i <= n; i++) arr[i] = scan.nextInt();
		int dp[] = new int[n + 1];
		dp[1] = arr[1];
		
		for(int i = 2; i <= n; i++) {
			dp[i] = arr[i];
			for(int j = i; j >= 1; j--) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[n]);
	}
	
}