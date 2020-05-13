import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		String str = scanner.next();
		int count[] = new int[26];
		int repeat = 0;
		int max = -1;
		int maxIndex = 0;
		for (int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);
			if (tmp >= 97) {
				count[tmp - 97]++;
			} else {
				count[tmp - 65]++;
			}
		}
		for (int i = 0; i < count.length; i++) {
			if (max < count[i]) {
				repeat = 0;
				max = count[i];
				maxIndex = i;
			} else if (max == count[i]) {
				repeat = 1;
			}
		}
		if (repeat == 1) {
			System.out.println("?");
		} else {
			System.out.printf("%c", maxIndex + 65);
		}
	}

}