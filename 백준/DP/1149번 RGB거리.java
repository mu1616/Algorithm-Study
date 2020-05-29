import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		m.solution();
	}

	public void solution() {
		int n =scan.nextInt();
		House houseList[] = new House[n];
		for(int i=0; i< n; i++) {
			int red = scan.nextInt();
			int green = scan.nextInt();
			int blue = scan.nextInt();
			houseList[i] = new House(red, green,blue);
		}
		int dp[][] = new int[n+1][3];
		dp[1][0] = houseList[0].red;
		dp[1][1] = houseList[0].green;
		dp[1][2] = houseList[0].blue;
		
		for(int i=2; i< n+1; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + houseList[i-1].red;
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + houseList[i-1].green;
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + houseList[i-1].blue;
			System.out.println(dp[i][0]);
			System.out.println(dp[i][1]);
			System.out.println(dp[i][2]);
		}
		
		System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
		
	}
	
	class House{
		int red;
		int green;
		int blue;
		
		House(int red, int green, int blue){
			this.red = red;
			this.green = green;
			this.blue= blue;
		}

		@Override
		public String toString() {
			return "House [red=" + red + ", green=" + green + ", blue=" + blue + "]";
		}
		
	}
	

}