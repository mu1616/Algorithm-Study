import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scan.nextInt();
		int sum = 0;
		int result = 0;
		for(int i=0; i< n; i++) {
			sum = i;
			String tmp = String.valueOf(i);
			for(int j=0; j< tmp.length(); j++) {
				sum = sum + tmp.charAt(j) - 48;
			}
			if(sum == n) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}


}