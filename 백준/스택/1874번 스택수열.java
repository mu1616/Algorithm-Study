import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Main m = new Main();
		m.solution();
	}

	public void solution() {
		Stack<Integer> stack = new Stack<>();
		int count = 1;
		StringBuilder result = new StringBuilder("");
		int n = scan.nextInt();
		int tmp;
		for(int i=0; i< n; i++) {
			tmp = scan.nextInt();
			if(tmp >= count) {
				for(int j=count; j <= tmp; j++) {
					stack.push(count);
					count = count + 1;
					result.append("+\n");
				}
				stack.pop();
				result.append("-\n");
			} else {
				if(stack.peek() == tmp) {
					stack.pop();
					result.append("-\n");
				}else {
					result = new StringBuilder("NO");
					break;
				}
			}	
		}
		System.out.println(result);
	}
}