import java.util.*;
class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Main m = new Main();
		m.solution();
	}
	
	public void solution() {
		int n = scan.nextInt();
		int m = scan.nextInt();
		int k = scan.nextInt();
		
		for(int i=0; i< k; i++) {
			if(2*m < n) {
				n--;
			}else {
				m--;
			}
		}
		int result = 0;
		while(n >=2 && m >= 1) {
			n = n - 2;
			m = m - 1;
			result++;
		}
		System.out.println(result);
	}
	
}