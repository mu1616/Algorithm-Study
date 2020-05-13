import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		String str = scanner.nextLine();
		String array[] = str.split(" ");
		char [] n1 = array[0].toCharArray();
		char [] n2 = array[1].toCharArray();
		
		for(int i=0; i<n1.length/2; i++) {
			char tmp = n1[i];
			n1[i] = n1[n1.length-1-i];
			n1[n1.length-1-i] = tmp;
		}
		for(int i=0; i<n2.length/2; i++) {
			char tmp = n2[i];
			n2[i] = n2[n2.length-1-i];
			n2[n2.length-1-i] = tmp;
		}
		int num1 = Integer.parseInt(String.valueOf(n1));
		int num2 = Integer.parseInt(String.valueOf(n2));
		int result = num1>num2?num1:num2;
		System.out.println(result);
	}
}