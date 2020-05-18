import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
		
	}

	public void solution() {
		int n = 5;
		int s[] = new int[n];
		s[0] = 1;
		s[1] = 2;
		s[2] = 4;
		for(int i=3; i< s.length; i++) {
			s[i] = s[i-1] + s[i-2] + s[i-3];
		}
		int answer = s[n-1];
		System.out.println(answer);
	}
	
	
}

