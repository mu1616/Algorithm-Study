import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int k = scan.nextInt();
		int l = scan.nextInt();
		
		int round = 1;
		
		while(true) {
			if(k % 2 ==0 && k - l == 1) {
				break;
			}
			
			if(l % 2 == 0 && l - k == 1) {
				break;
			}
			
			k = (int)Math.ceil((double)k / 2);
			l = (int)Math.ceil((double)l / 2);
			
			round++;
		}
		
		System.out.println(round);
	}
}