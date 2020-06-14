import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		long n = scan.nextLong();
		long cnt = 0;
		long sum = 0;
		while(sum < n) {
			cnt++;
			sum = sum + cnt;
		}
		long result;
		if(sum > n) 
			result = cnt - 1;
		else
			result = cnt;
		
		System.out.println(result);
	}

}