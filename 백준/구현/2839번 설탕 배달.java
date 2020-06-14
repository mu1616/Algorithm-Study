import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int result = -1;
		if (n % 5 == 0) {
			result = n / 5;
		} else {
			int cnt = 0;
			for (int i = n; i >= 0; i = i - 3) {
				if(i%5 == 0) {
					result = cnt + i/5;
					break;
				}
				cnt++;
			}
		}
		
		System.out.println(result);
	}

}
