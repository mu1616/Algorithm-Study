import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	Stack<Integer> stack = new Stack<>();
	int n;
	int min = 1000;
	int array[][];
	public static void main(String[] args) {
		Main m = new Main();
		m.solution();
	}

	public void solution() {
		n = scan.nextInt();
		array = new int[n][n];
		for(int i=0; i< n; i++) {
			for(int j=0; j< n; j++) {
				array[i][j] = scan.nextInt();
			}
		}
		int numbers[] = new int[n];
		for(int i=0; i< n; i++) numbers[i] = i;
		combi(numbers, 0, n/2);
		System.out.println(min);
	}
	
	public void combi(int array[], int start, int r) {
		if(r==0) {
			int result = cal();
			if(min > result) min = result;
		}else {
			for(int i=start; i< array.length; i++) {
				stack.push(array[i]);
				combi(array, i+1, r-1);
				stack.pop();
			}
		}
	}
	
	public int cal() {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i< n; i++) list.add(i);
		list.removeAll(stack);
		int sum1 = 0;
		for(int i=0; i< stack.size(); i++) {
			int tmp = stack.get(0);
			for(int j=1; j< stack.size(); j++) {
				sum1 = sum1 + array[tmp][stack.get(j)];
			}
			stack.remove(0);
			stack.add(tmp);
		}
		int sum2 = 0;
		for(int i=0; i< list.size(); i++) {
			int tmp = list.get(0);
			for(int j=1; j< list.size(); j++) {
				sum2 = sum2 + array[tmp][list.get(j)];
			}
			list.remove(0);
			list.add(tmp);
		}
		return Math.abs(sum1-sum2);
		
	}

}