import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	ArrayList<Long> list = new ArrayList<>();

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int cnt = 0;
		
		for(int i = 0; i < 10; i++) {
			recursion(i, i);
		}
		
		Collections.sort(list);
		
		if(n < list.size()) {
			System.out.println(list.get(n));
		} else {
			System.out.println("-1");
		}
	}

	public void recursion(long n, int before) {	
		list.add(n);
		for(int i = 0; i < 10; i++) {
			if(before > i) {
				recursion(n * 10 + i, i);
			}
		}
	}
}