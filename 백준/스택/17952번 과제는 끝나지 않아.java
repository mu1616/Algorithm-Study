import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		Stack<Assignment> stack = new Stack<>();
		int sum = 0;
		int n = scan.nextInt();
		
		for(int i = 0; i < n; i++) {
			int isAssignment = scan.nextInt();
			
			if(isAssignment == 1) {
				stack.push(new Assignment(scan.nextInt(), scan.nextInt()));
			}
			
			if(stack.isEmpty()) continue;
			
			Assignment curr = stack.peek();
			curr.t -= 1;
			if(curr.t == 0) {
				sum += curr.a;
				stack.pop();
			}
		}
		
		System.out.println(sum);
	}
	
	class Assignment {
		int a;
		int t;
		Assignment(int a, int t) {
			this.a = a;
			this.t = t;
		}
	}
}