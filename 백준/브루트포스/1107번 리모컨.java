import java.math.BigInteger;
import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int btn[];
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int m = scan.nextInt();
		btn = new int[10];
		
		for(int i=0; i< m; i++) {
			int k = scan.nextInt();
			btn[k] = 1;  //1이면 사용 불가
		}
		
		boolean all = true;
		for(int i=0; i< 10; i++) {
			if(btn[i] == 0) {
				all = false;
			}
		}
		// 모든 버튼이 고장이라면?
		if(all == true) {
			System.out.println(Math.abs(100-n));
			return;
		}
		
		String ch = String.valueOf(n);
		int diff = Math.abs(100 - n);
		l :for(int i=0; i <= 999999; i++) {
			String a = String.valueOf(i);
			for(int j=0; j< a.length(); j++) {
				if(btn[Integer.parseInt(a.substring(j,j+1))] == 1)
					continue l;
			}
			if(diff > Math.abs(n - i) + a.length()) {
				diff = Math.abs(n-i) + a.length();
			}
		}
		
		System.out.println(diff);
		
	}
	

	
}
