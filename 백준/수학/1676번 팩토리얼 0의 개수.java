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
		BigInteger num = new BigInteger("1");
		for (int i = 2; i <= n; i++) {
			if (i % 10 == 2 || i % 10 == 5 || i % 10 == 0) {
				num = num.multiply(new BigInteger(String.valueOf(i)));
			}
		}
		int answer = 0;
		String str = num.toString();
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == '0') {
				answer++;
			} else {
				break;
			}
		}
		System.out.println(answer);
	}
}
