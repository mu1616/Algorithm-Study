import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int tmp[] = new int[6];
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
		
	}

	public void solution() {
		int array[];
		while(true) {
			int n = scan.nextInt();
			if(n==0) break;
			
			array = new int[n];
			for(int i=0; i< n; i++) {
				array[i] = scan.nextInt();
			}
			Arrays.sort(array);
			combination(array, 0, 6);
			System.out.println();
		}
		
	}
	
	public void combination(int []array, int start, int r) {
		if(r==0) {
			for(int n : tmp) {
				System.out.print(n+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start; i< array.length; i++) {
			tmp[6-r] = array[i];
			combination(array, i+1, r-1);
		}
	}


}