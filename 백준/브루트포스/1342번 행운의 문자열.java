import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int answer = 0;
	int counts[] = new int[26];
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		String str = scan.next();
		char arr[] = str.toCharArray();
		for(int i = 0; i < arr.length; i++) {
			counts[arr[i] - 'a']++;
		}
		
		permu(arr, 0, arr.length);
		for(int i = 0; i < 26; i++) {
			answer /= factorial(counts[i]);
		}
		
		
		System.out.println(answer);
	}
	
	public void permu(char arr[], int start, int r) {
		if(r == 0) {			
			answer++;
			return;
		}
		
		for(int i = start; i < arr.length; i++) {
			swap(arr, start, i);
			if((start >= 1 && arr[start] != arr[start - 1]) || start < 1) {
				permu(arr, start + 1, r - 1);
			}
			swap(arr, start, i);
		}
	}
	
	public void swap(char arr[], int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public int factorial(int n) {
		int result = 1;
		for(int i = 1; i <= n; i++)
			result *= i;
		
		return result;
	}
}