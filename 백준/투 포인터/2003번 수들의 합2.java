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
		int array[] = new int[n];
		
		for(int i =0; i < n; i++)
			array[i] = scan.nextInt();
		
		int left = -1;
		int right = 1;
		int sum = array[0];
		int answer = 0;
		
		while(true) {
			if(sum < m) {
				if(right == n) break;
				sum = sum + array[right];
				right++;				
				
			} else if (sum == m) {
				answer++;
				left++;
				sum = sum - array[left];
				
			} else {
				left++;
				sum = sum - array[left];
			}
			
		}
		
		System.out.println(answer);
		
	}
}