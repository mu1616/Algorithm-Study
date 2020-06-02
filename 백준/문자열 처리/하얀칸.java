import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int sum = 0;
		int front = 0;   //0 = white, 1 = black
		for (int i = 0; i < 8; i++) {
			String str = scan.next();
			for (int j = 0; j < 8; j++) {
				if(front == 0) {
					if(j%2==0 && str.charAt(j) =='F') 
						sum++;				
				} else 
					if(j%2 !=0 && str.charAt(j) == 'F') {
						sum++;				
				}
			}
			front = (front==0)?1:0;
		}
		System.out.println(sum);
	}

}