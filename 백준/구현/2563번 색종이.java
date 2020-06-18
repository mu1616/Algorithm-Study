import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int array[][] = new int[100][100];
		
		for(int i=0; i< n; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			
			for(int j=b; j< b+10; j++) {
				for(int k=a; k< a+10; k++) {
					array[j][k] = 1;
					//System.out.println("HI");
				}
			}
		}
		
		int result = 0;
		
		for(int i=0; i< 100; i++) {
			for(int j=0; j< 100; j++) {
				if(array[i][j] == 1) {
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
	


}
