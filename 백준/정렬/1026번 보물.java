import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int a[] = new int[n];
		Integer b[] = new Integer[n];
		for(int i=0; i< n; i++) {
			a[i] = scan.nextInt();
		}
		for(int i=0; i< n; i++) {
			b[i] = scan.nextInt();
		}
		Arrays.sort(a);
		Arrays.sort(b, Collections.reverseOrder());
		int sum = 0;
		for(int i=0; i< n; i++) {
			sum = sum + (a[i]*b[i]);
		}
		System.out.println(sum);
	}



}