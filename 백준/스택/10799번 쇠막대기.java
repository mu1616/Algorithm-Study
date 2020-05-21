import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
		
	}

	public void solution() {
		String str = scan.next();
		Stack<Character> st = new Stack<>();
		int balance = 0;
		int sum = 0;
		int laser = 0;
		for(int i=0; i< str.length(); i++)
			st.push(str.charAt(i));
		
		while(st.size() != 0) {
			char a = st.pop();
			if(a == ')') {
				if(st.peek() == '(') {
					sum = sum + balance;
					st.pop();
					laser = 1;
				} else {
					balance++;
				}
			}else {
				sum++;
				balance--;
			}
		}
		System.out.println(sum);
		
	}
	


}