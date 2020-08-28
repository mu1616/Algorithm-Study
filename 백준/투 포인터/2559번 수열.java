import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);


	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int k = scan.nextInt();
		int arr[] = new int[n];
		
		for(int i = 0; i < n; i++)
			arr[i] = scan.nextInt();
		
		int max = 0;
		for(int i = 0; i < k; i++)
			max += arr[i];
		
		int curr = max;
		for(int i = 1; i <= n - k; i++) {
			curr = curr - arr[i - 1] + arr[i + k - 1];
			if(max < curr) max = curr;
		}
		
		System.out.println(max);
	}
}