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
		int result[] = new int[n];;
		for(int i=0; i< n; i++) {
			array[i] = scan.nextInt();
			result[i] = -1;
		}
		
		for(int i=0; i< n; i++) {
			int k = array[i];
			for(int j=0; j<=k; j++) {
				if(result[j] != -1 && result[j] < i+1)
					k++;
			}
			result[k] = i+1;
		}
		
		for(int i : result)
			System.out.print(i+" ");

	}
	

	
	
}

