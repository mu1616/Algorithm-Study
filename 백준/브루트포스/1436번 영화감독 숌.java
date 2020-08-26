import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int i = 0;
		
		while(n != 0) {
			if(String.valueOf(i).contains("666")) {
				n--;
			}
			
			i++;
		}
		
		System.out.println(i - 1);
	}

}