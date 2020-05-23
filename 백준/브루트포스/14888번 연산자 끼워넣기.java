import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	ArrayList<Integer> calList = new ArrayList<>();
	int numbers[];
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();

	}

	public void solution() {
		int n = scan.nextInt();
		numbers = new int[n];
		for(int i=0; i< n; i++) {
			numbers[i] = scan.nextInt();
		}
		ArrayList<Character> list = new ArrayList<>();
		int tmp = scan.nextInt();
		for(int i=0; i< tmp; i++) {
			list.add('+');
		}
		tmp = scan.nextInt();
		for(int i=0; i< tmp; i++) {
			list.add('-');
		}
		tmp = scan.nextInt();
		for(int i=0; i< tmp; i++) {
			list.add('*');
		}
		tmp = scan.nextInt();
		for(int i=0; i< tmp; i++) {
			list.add('/');
		}
		char operators[] = new char[list.size()];
		for(int i=0; i< list.size(); i++) {
			operators[i] = list.get(i);
		}
		permutation(operators, 0, operators.length);
		Collections.sort(calList);
		System.out.println(calList.get(calList.size()-1));
		System.out.println(calList.get(0));
	}
	
	public void permutation(char [] operators, int start, int r) {
		if(r==0) {
			int result = numbers[0];
			for(int i=0; i< operators.length; i++) {
				result = cal(result, numbers[i+1], operators[i]);
			}
			calList.add(result);
		}else {
			for(int i=start; i< operators.length; i++) {
				swap(operators, start, i);
				permutation(operators, start+1, r-1);
				swap(operators, start, i);
			}
		}
	}
	
	public void swap(char [] array, int i, int j) {
		char tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public int cal(int a, int b, char c) {
		int result = 0;
		if(c == '+') {
			result = a+b;
		}else if(c == '-') {
			result = a-b;
		}else if(c == '*') {
			result = a*b;
		}else if(c == '/') {
			result = a/b;
		}
		return result;
	}

}