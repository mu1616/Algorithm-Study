import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}
	
	public void solution() {
		int array[] = new int[50];
		array[0] = 1;
		for(int i=1; i< 50; i++) {
			array[i] = array[i-1] + i + 1;
		}
		int n = scan.nextInt();
		for(int i=0; i< n; i++) {
			int a = scan.nextInt();
			boolean b = false;
			for(int j = 0; j < 50; j++) {
				int sum = array[j];
				for(int k = 0; k < 50; k++) {
					int sum2 = sum + array[k];
					for(int l = 0; l < 50; l++) {
						int sum3 = sum2 + array[l];
						if(sum3 == a) {
							b = true;
						}
					}
				}
			}
			if(b == true)
				System.out.println("1");
			else 
				System.out.println("0");
		}
	}
	

	
	
}



