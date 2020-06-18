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
		int array[][] = new int[n][m];
		
		for(int i=0; i< n; i++) {
			String str = scan.next();
			for(int j=0; j< m; j++) {
				array[i][j] = Integer.parseInt(str.substring(j, j+1));
			}
		}
		
		int max = 1;
		
		for(int i=0; i< n; i++) {
			for(int j=0; j< m; j++) {
				int a = n-i-1;
				int b = m-j-1;
				int len = Math.min(a, b);
				for(int k=1; k<= len; k++) {
					if(array[i][j] == array[i+k][j] && array[i][j] == array[i][j+k] && array[i][j] == array[i+k][j+k]) {
						int area = (k+1)*(k+1);
						if(max < area) {
							max = area;
						}
					}
				}
			}
		}
		System.out.println(max);
		
	}
}
