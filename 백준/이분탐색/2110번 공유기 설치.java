import java.util.*;
import java.util.stream.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int c = scan.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) arr[i] = scan.nextInt();
		
		Arrays.sort(arr);

		int left = 1;
		int right = arr[n - 1] - arr[0];
		int d = 0;
		int ans = 0;
		
		while(left <= right) {
			int mid = (left + right) / 2; // mid = 인접한 두 공유기의 최대 거리
			int start = arr[0];
			int cnt = 1; // 설치 개수
			
			for(int i = 1; i < n; i++) {
				d = arr[i] - start;
				if(mid <= d) {
					cnt++;
					start = arr[i];
				}
			}
			
			if(cnt >= c) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(ans);
	}
}