import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int m = scan.nextInt();
		String s = scan.next();
		char array[] = s.toCharArray();
		
		int pSize = 2 * n + 1;
		int currentSize = 0;
		int cnt = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				if (array[i] == 'I') {
					currentSize++;
				}
				continue;
			}

			if (array[i] != array[i - 1]) {
				currentSize++;
			} else {
				if (array[i] == 'I') {
					currentSize = 1;
				} else {
					currentSize = 0;
				}
			}

			if (currentSize >= pSize && array[i] == 'I') {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
