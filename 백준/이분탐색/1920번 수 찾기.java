import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int array[][];
	int max;

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int a[] = new int[n];
		
		for(int i=0; i< n; i++)
			a[i] = scan.nextInt();
		
		int m = scan.nextInt();
		int b[] = new int[m];
		
		for(int i=0; i< m; i++)
			b[i] = scan.nextInt();
		
		Arrays.sort(a);
		
		l:for(int i=0; i< m; i++) {
			int left = 0;
			int right = n - 1;
			
			while(left <= right) {
				int mid = (left + right) / 2;
				
				if(a[mid] < b[i]) {
					left = mid + 1;
					
				} else if (a[mid] > b[i]) {
					right = mid - 1;
					
				} else if(a[mid] == b[i]) {
					System.out.println("1");
					continue l;
				}
			}
			System.out.println("0");
		}
	}
}