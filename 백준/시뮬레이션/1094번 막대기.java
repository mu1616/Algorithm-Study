import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int x = scan.nextInt();
		int sum = 0;
		int curr = 64;
		int count = 0;
		
		if(x == 64) {
			System.out.println("1");
			return;
		}
		
		while(sum != x) {
			curr = curr / 2;
			
			if(sum + curr <= x) {
				sum = sum + curr;
				count++;
			}
		}
		
		System.out.print(count);
	}
}