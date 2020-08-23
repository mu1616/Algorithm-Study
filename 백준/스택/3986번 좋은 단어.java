import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		Main main = new Main();
		int n = scan.nextInt();
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			sum += main.solution();
		}
		
		System.out.print(sum);
	}

	public int solution() {
		String str = scan.next();
		Stack<Character> st = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			if(st.isEmpty()) {
				st.push(a);
				continue;
			}
			
			if(st.peek() == a) {
				st.pop();
			} else {
				st.push(a);
			}
		}
		
		if(st.isEmpty()) {
			return 1;
		} else {
			return 0;
		}

	}

}