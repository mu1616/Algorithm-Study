import java.util.Scanner;
import java.util.Stack;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main (String[] args){
		Main main = new Main();
		main.solution();
	}

	public void solution(){
		String str = scan.next();
		String bomb = scan.next();
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
			if(stack.size() < bomb.length()) {
				continue;
			}
			
			boolean flag = true;
			for(int j = 0; j < bomb.length(); j++) {
				if(stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
					flag = false;
					break;
				}
			}

			if(flag) {
				for(int j = 0; j < bomb.length(); j++) stack.pop();
			}
		}
		
		StringBuilder sb = new StringBuilder("");
		if(stack.isEmpty()) {
			System.out.println("FRULA");
		} else {
			for(char c : stack) sb.append(c);
			System.out.println(sb.toString());
		}
		
	}
}