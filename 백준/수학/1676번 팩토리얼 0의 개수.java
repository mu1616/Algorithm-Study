import java.math.BigInteger;
import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int count =  0;
		for (int i = 1; i <= n; i++) {
			count += count(i);
		}
		System.out.println(count);
	}
	
	public int count(int num) {
		int count = 0;
		while (true) {
			if (num % 5 == 0) {
				count++;
				num = num / 5;
			} else {
				break;
			}
		}
		return count;
	}
}
