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
		boolean dp[][] = new boolean[n + 1][n + 1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j<= n; j++) {
				if(i + j - 1 > n) continue;
				
				if(j == i + j - 1) {
					dp[j][i + j - 1] = true;
					continue;
				}

				if((j + 1 == i + j - 1) || (j + 2 == i + j - 1)) {
					if(arr[j] == arr[i + j - 1]) dp[j][i + j - 1] = true;
					continue;
				}
				
				if((arr[j] == arr[i + j - 1]) && dp[j + 1][i + j - 2]) {
					dp[j][i + j - 1] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder("");
		int m = scan.nextInt();
		for(int i = 0; i < m; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			if(dp[a][b]) sb.append("1\n");
			else sb.append("0\n");
		}
		
		System.out.println(sb.toString());
	}
}