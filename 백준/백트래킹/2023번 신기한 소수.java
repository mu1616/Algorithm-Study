import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		recursion("", n);
	}
	
	public void recursion(String num, int n) {
		if(num.length() == n) {
			System.out.println(num);
			return;
		}
		for(int i=0; i<= 9; i++) {
			if(i==0 && num.length() == 0)
				continue;
			
			if(isPrime(Integer.parseInt(num+i))) {
				recursion(num+i, n);
			}
		}
	}
	
	
	public boolean isPrime(int num) {
		if(num == 1) {
			return false;
		}
		
		for(int i=2; i< num; i++) {
			if(num%i == 0) {
				return false;
			}
		}
		return true;
	}

}
