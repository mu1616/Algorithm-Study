import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
			
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int min = -1;
		int n = scan.nextInt();
		int arr[] = new int[n];
		int answer[] = new int[n];
		String str1 = scan.next();
		for(int i = 0; i < n; i++) arr[i] = str1.charAt(i) - '0';
		String str2 = scan.next();
		for(int i = 0; i < n; i++) answer[i] = str2.charAt(i) - '0';

		int cnt = 0;
		for(int i = 0; i < n - 1; i++) {
			if(arr[i] != answer[i]) {
				arr[i] = (arr[i] + 1) % 2;
				arr[i + 1] = (arr[i + 1] + 1) % 2;
				if(i + 2 < n) arr[i + 2] = (arr[i + 2] + 1) % 2;
				cnt++;
			}
		}
		
		if(arr[n - 1] == answer[n - 1]) 
			min = cnt;
		
		
		for(int i = 0; i < n; i++) arr[i] = str1.charAt(i) - '0';
		arr[0] = (arr[0] + 1) % 2;
		arr[1] = (arr[1] + 1) % 2;
		cnt = 1;
		for(int i = 0; i < n - 1; i++) {
			if(arr[i] != answer[i]) {
				arr[i] = (arr[i] + 1) % 2;
				arr[i + 1] = (arr[i + 1] + 1) % 2;
				if(i + 2 < n) arr[i + 2] = (arr[i + 2] + 1) % 2;
				cnt++;
			}
		}
		
		if(arr[n - 1] == answer[n - 1]) {
			if(min == -1) {
				min = cnt;
			} else if(min > cnt) {
				min = cnt;
			}
		}
		
		System.out.println(min);
	}
}