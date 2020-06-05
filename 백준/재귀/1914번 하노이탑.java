import java.math.BigInteger;
import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int cnt = 0;
	int n;
	StringBuffer str = new StringBuffer("");
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		n = scan.nextInt();
		if(n<=20) {
			recursion(n, 1, 3);
			System.out.println(cnt);
			System.out.println(str.toString());
		} else {
			
			BigInteger dp[] = new BigInteger[n+1];
			dp[1] = new BigInteger("1");
			for(int i=2; i< n+1; i++) {
				dp[i] = dp[i-1].multiply(new BigInteger("2")).add(new BigInteger("1"));
				
			}
			System.out.println(dp[n]);
		}
	}
	
	
	public void recursion(int height, int start, int dest) {
		if(height==1) {
			cnt++;
			if(n <= 20)
				str.append(start+" "+dest+"\n");
			return;
		}
		recursion(height-1, start, 6-start-dest);
		recursion(1, start, dest);
		recursion(height-1, 6-start-dest, dest);
	}

	


}