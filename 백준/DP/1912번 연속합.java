import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int array[] = new int[n];
		for(int i=0; i< n; i++)
			array[i] = scan.nextInt();
		
		int dp[] = new int[n];
		dp[0] = array[0];
		int max = dp[0];
		
		for(int i=1; i< n; i++) {
			if(dp[i-1] + array[i] > array[i]) {
				dp[i] = dp[i-1] + array[i];
			} else {
				dp[i] = array[i];
			}
			if(max < dp[i])
				max = dp[i];
		}
		
		System.out.print(max);
	}

}