import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int array[] = new int[n];
		
		for(int i=0; i< n; i++)
			array[i] = scan.nextInt();
		
		Arrays.sort(array);
		
		int sum = 0;
		
		for(int i=0; i< n; i++) {
			if(array[i] > sum+1) {
				break;
			}
			sum = sum + array[i];
		}
		

		System.out.println(sum+1);
		
	}
	


}