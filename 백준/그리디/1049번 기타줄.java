import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Main m = new Main();
		m.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int m = scan.nextInt();
		int pacs[] = new int[m];
		int ones[] = new int[m];
		for(int i=0; i<m; i++) {
			pacs[i] = scan.nextInt();
			ones[i] = scan.nextInt();
		}
		Arrays.sort(pacs);
		Arrays.sort(ones);
		int pac = pacs[0];
		int one = ones[0];
		int sum = 0;
		while(n != 0) {
			if(n>=6) {
				if(pac < 6*one) {
					sum = sum + pac;
					n = n - 6;
				} else {
					sum = sum + 6*one;
					n = n - 6;
				}
			}else {
				if(pac < n*one) {
					sum = sum + pac;
					n = n - n;
				} else {
					sum = sum + n*one;
					n = n - n;
				}
			}
		}
		System.out.println(sum);
	}
	
}