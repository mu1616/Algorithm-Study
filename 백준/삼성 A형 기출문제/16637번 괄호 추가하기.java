import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	Stack<Integer> stack = new Stack<>();
	String array[];
	long max = Long.MIN_VALUE;
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		array = new String[n];

		String str = scan.next();

		for (int i = 0; i < n; i++)
			array[i] = str.substring(i,i+1);

		int oper[] = new int[str.length() / 2];
		for (int i = 1; i <= oper.length; i++) {
			oper[i - 1] = (i * 2) - 1;
		}
		
		for(int i=(oper.length+1)/2; i >=0; i--) {
			combi(oper, 0, i);
		}

		System.out.println(max);

		
	}

	public void combi(int oper[], int start, int r) {
		if (r == 0) {
			ArrayList<String> list = new ArrayList<>();

			for(int i=0; i< array.length; i++) {
				if(stack.contains(i)) {
					list.remove(list.size()-1);
					list.add(String.valueOf(calc(array[i-1], array[i], array[i+1])));
					i++;
				} else {
					list.add(array[i]);
				}
			}
			
			String sum = list.get(0);
			for(int i=1; i< list.size()-1; i++) {
				if(i%2 == 1) {
					sum = String.valueOf(calc(sum, list.get(i), list.get(i+1)));
				}
			}
			
			if(max < Long.parseLong(sum))
				max = Long.parseLong(sum);
		} else {
			for (int i = start; i < oper.length; i++) {
				if (stack.isEmpty() || stack.peek() + 4 <= oper[i]) {
					stack.push(oper[i]);
					combi(oper, i + 1, r - 1);
					stack.pop();
				}
			}
		}
	}

	public long calc(String n1, String op, String n2) {
		if (op.equals("+")) {
			return Long.parseLong(n1) + Long.parseLong(n2);
		}
		
		if (op.equals("-")) {
			return Long.parseLong(n1) - Long.parseLong(n2);
		}
		
		if (op.equals("*")) {
			return Long.parseLong(n1) * Long.parseLong(n2);
		}
		
		return 0;
	}

}
