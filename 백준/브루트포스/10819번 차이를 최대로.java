import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int max = 0;
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int arr[] = new int[n];
		
		for(int i = 0; i < n; i++)
			arr[i] = scan.nextInt();
		
		permu(arr, 0, n);
		
		System.out.println(max);
	}
	
	public void permu(int [] arr, int start, int r) {
		if(r == 0) {
			int sum = 0;
			for(int i = 0; i < arr.length - 1; i++) {
				sum += Math.abs(arr[i] - arr[i + 1]);
			}
			
			if(sum > max)
				max = sum;
			
		} else {
			for(int i = start; i < arr.length; i++) {
				swap(arr, start, i);
				permu(arr, start + 1, r - 1);
				swap(arr, start, i);
			}
		}
	}
	
	public void swap(int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}