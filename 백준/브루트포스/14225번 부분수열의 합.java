import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	HashSet<Integer> set = new HashSet<>();
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) arr[i] = scan.nextInt();
		

		recursion(arr, 0, 0);
		
		int result = 0;
		for(int i = 1; i <= 2000000; i++) {
			if(!set.contains(i)) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
	}
	
	public void recursion(int arr[], int start, int sum) {
		if(start == arr.length) {
			return;
		}
		
		for(int i = start; i < arr.length; i++) {
			set.add(sum + arr[i]);
			recursion(arr, i + 1, sum + arr[i]);
		}
	}
}