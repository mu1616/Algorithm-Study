import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	ArrayList<C> cList = new ArrayList<>();
	ArrayList<C> pList = new ArrayList<>();
	int answer[][] = new int[9][9];
	Stack<C> stack = new Stack<>();
	int min = 99999999;
	int m;
	int array[][];

	public static void main(String[] args) {
		Main m = new Main();
		m.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		m = scan.nextInt();
		array = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = scan.nextInt();
				if (array[i][j] == 2) {
					C c = new C(i, j);
					cList.add(c);
				}
				if (array[i][j] == 1) {
					C c = new C(i, j);
					pList.add(c);
				}
			}
		}
		combi(0, m);
		System.out.println(min);

	}

	public void combi(int start, int r) {
		if (r == 0) {
			int k = calDist();
			if (k < min)
				min = k;
		} else {
			for (int i = start; i < cList.size(); i++) {
				stack.push(cList.get(i));
				combi(i + 1, r - 1);
				stack.pop();
			}
		}
	}

	public int calDist() {
		int sum = 0;
		for (int i = 0; i < pList.size(); i++) {
			int min = Math.abs(stack.get(0).row - pList.get(i).row) + Math.abs(stack.get(0).col - pList.get(i).col);
			for (C c : stack) {
				int dist = Math.abs(c.row - pList.get(i).row) + Math.abs(c.col - pList.get(i).col);
				if (dist < min)
					min = dist;
			}
			sum = sum + min;
		}
		return sum;
	}

	class C {
		int row;
		int col;

		C(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

}