import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();

	}

	public void solution() {
		int n = scan.nextInt();
		int k = 1000 - n;
		int sum = 0;
		while(k>=500) {
			k = k - 500;
			sum ++;
		}
		while(k>=100) {
			k = k - 100;
			sum++;
		}
		while(k >= 50) {
			k = k - 50;
			sum++;
		}
		while(k >= 10) {
			k = k-10;
			sum++;
		}
		while(k >= 5) {
			k = k - 5;
			sum++;
		}
		while(k >= 1) {
			k = k - 1;
			sum++;
		}
		System.out.println(sum);
	}
	


}