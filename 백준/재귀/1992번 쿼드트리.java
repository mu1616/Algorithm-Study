import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int array[][];

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		array = new int[n][n];
		for (int i = 0; i < n; i++) {
			String str = scan.next();
			for (int j = 0; j < n; j++) {
				array[i][j] = str.charAt(j) - '0';
			}
		}

		recursion(0, 0, n);

	}

	public void recursion(int x, int y, int length) {
		int num = array[y][x];
		boolean canCompress = true;

		for (int i = y; i < y + length; i++) {
			for (int j = x; j < x + length; j++) {
				if (array[i][j] != num) {
					canCompress = false;
				}
			}
		}

		if (canCompress) {
			System.out.print(num);
		} else {
			System.out.print("(");
			recursion(x, y, length / 2);
			recursion(x + length / 2, y, length / 2);
			recursion(x, y + length / 2, length / 2);
			recursion(x + length / 2, y + length / 2, length / 2);
			System.out.print(")");
		}


	}

}
