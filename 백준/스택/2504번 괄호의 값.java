import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Main m = new Main();
		m.solution();
	}

	public void solution() {
		String str = scan.next();
		Stack<Integer> st1 = new Stack<>();
		Stack<Integer> st2 = new Stack<>();
		boolean complete = true;
		for(int i=0; i< str.length(); i++) {
			char c = str.charAt(i);
			if(c == '(') {
				st1.push(1);
			}
			if(c == ')') {
				if(st1.isEmpty() || str.charAt(i-1) == '[') {
					complete = false;
				} else {
					st1.pop();
				}
			}
			if(c == '[') {
				st2.push(1);
			}
			if(c == ']') {
				if(st2.isEmpty() || str.charAt(i-1) == '(') {
					complete = false;
				} else {
					st2.pop();
				}
			}
		}
		if(!complete || !st1.isEmpty() || !st2.isEmpty()) {
			System.out.println("0");
		} else {
			int tmp;
			Stack<String> st = new Stack<>();
			for(int i=0; i< str.length(); i++) {
				String c = String.valueOf(str.charAt(i));
				if(c.equals("(")) {
					st.push(c);
				} else if(c.equals(")")) {		
					tmp = 0;
					if(st.peek().equals("(")) {
						st.pop();
						st.push("2");
					} else {
						while(!(st.peek().equals("("))) {
							tmp = tmp + Integer.parseInt(st.pop());
						}
						st.pop();
						tmp = tmp * 2;
						st.push(String.valueOf(tmp));
					}
				} else if(c.equals("[")) {
					st.push(c);
				} else if(c.equals("]")) {
					tmp = 0;
					if(st.peek().equals("[")) {
						st.pop();
						st.push("3");
					} else {
						while(!(st.peek().equals("["))) {
							tmp = tmp + Integer.parseInt(st.pop());
						}
						st.pop();
						tmp = tmp * 3;
						st.push(String.valueOf(tmp));
					}
				}
			}
			int result = 0;
			for(String t : st) {
				result = result + Integer.parseInt(t);
			}
			System.out.println(result);
		}
		
		
	}
}