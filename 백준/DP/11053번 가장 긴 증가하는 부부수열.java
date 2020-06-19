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
		dp[0] = 1;
		int max = 1;
		
		for(int i=1; i< n; i++) {
				dp[i] = 1;
			for(int j=i-1; j>=0; j--) {
				if(array[j] < array[i] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
			if(max < dp[i])
				max = dp[i];
		}
		System.out.print(max);
		
	}
	
	
}