import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	Stack<Integer> stack = new Stack<>();
	int cnt;
	int s;
	public static void main(String[] args) {
		Main m = new Main();
		m.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		s = scan.nextInt();
		int array[] = new int[n];
		for(int i=0; i< n; i++) {
			array[i] = scan.nextInt();
		}
		for(int i=1; i<= n; i++) {
			combi(array, 0, i);
		}
		System.out.println(cnt);
	}

	public void combi(int array[], int start, int r) {
		if (r == 0) {
			int sum = 0;
			for(int t : stack) {
				sum = sum + t;
			}
			if(sum == s) cnt++;
		} else {
			for (int i = start; i < array.length; i++) {
				stack.push(array[i]);
				combi(array, i + 1, r - 1);
				stack.pop();
			}
		}
	}

}