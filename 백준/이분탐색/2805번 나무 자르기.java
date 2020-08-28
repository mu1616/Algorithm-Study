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
		long trees[] = new long[n];
		for(int i = 0; i < n; i++) trees[i] = scan.nextLong();
		
		long left = 0;
		long right = 1000000000;
		long answer = 0;

		while(left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;
			
			for(int i = 0; i < trees.length; i++) {
				if(trees[i] > mid) sum += trees[i] - mid;
			}
			
			if(m <= sum) {
				left = mid + 1;
				answer = mid;
			} else {
				right = mid - 1;
			}
		}
	
		System.out.println(answer);
	}
}