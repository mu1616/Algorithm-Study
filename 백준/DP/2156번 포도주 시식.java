import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int array[] = new int[n+1];
		for(int i=1; i< n+1; i++)
			array[i] = scan.nextInt();
		
		int dp[] = new int[n+1];
		dp[1] = array[1];
		int max = array[1];
		for(int i=2; i< n+1; i++) {
			if(i==2) {
				dp[i] = dp[i-1] + array[i];
			} else {
				dp[i] = Math.max(dp[i-2] + array[i], dp[i-3] + array[i] + array[i-1]);
				dp[i] = Math.max(dp[i], dp[i-1]);
			}
			//System.out.println(dp[i]);
			if(max < dp[i]) max = dp[i];
		}
		System.out.println(max);
	}

}