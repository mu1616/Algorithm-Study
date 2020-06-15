import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	long f[] = new long[21];
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		
		f[1] = 1;
		for(int i=2; i< 21; i++) {
			f[i] = f[i-1]*i;
		}
		
		int k = scan.nextInt();
		
		if(k == 1) {
			problem1(n);
		} else {
			problem2(n);
		}
		
	}
	
	public void problem1(int n) {
		long target = scan.nextLong();
		int array[] = new int[n];
		boolean visited[] = new boolean[21];
		
		for(int i=0; i< n; i++) {
			long a = f[n-i-1];
			for(int j=1; j<= n; j++) {
				if(visited[j])
					continue;
				if(n-i-1 == 0) {
					array[i] = j;
				}
				else if(a < target) {
					target = target - a;
					continue;
				} else {
					array[i] = j;
					visited[j] = true;
					break;
				}
			}
		}
		
		for(int i : array) {
			System.out.print(i+" ");
		}
		
	}
	
	public void problem2(int n) {
		int target[] = new int[n];
		
		for(int i=0; i< n; i++)
			target[i] = scan.nextInt();
		
		boolean visited[] = new boolean[21];
		long answer = 1;
		
		for(int i=0; i< n; i++) {
			for(int j=1; j< target[i]; j++) {
				if(!visited[j])
					answer = answer + f[n-i-1];
			}
			visited[target[i]] = true;
		}
		System.out.println(answer);
	}
	

	
	
}
