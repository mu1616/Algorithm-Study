import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		int n = scanner.nextInt();
		int result = 99;
		if(n==1000) n = 999;
		if(n<=99) {
			System.out.println(n);
		}else {
			for(int i=100; i<= n; i++) {
				int a = i/100;
				int b = i%100/10;
				int c = i%100%10;
				if((a-b) == (b-c)) {
					result++;
				}
			}
			System.out.println(result);
		}
	}
}