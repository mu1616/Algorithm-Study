import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int stock[] = { 0, 5, 5, 5, 5, 5 };
	int result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int paper[][] = new int[10][10];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				paper[i][j] = scan.nextInt();
			}
		}

		recursion(paper, 0, 0);

		if (result == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(result);
	}

	public void recursion(int array[][], int n, int sum) {
		if (n == 100) {
			if (result > sum)
				result = sum;
			return;
		}

		int x = n % 10;
		int y = n / 10;

		if (array[y][x] == 1) {
			for (int i = 5; i >= 1; i--) {
				if (isCover(array, x, y, i)) {
					if (stock[i] != 0) {
						int copy[][] = cover(array, x, y, i);
						stock[i] = stock[i] - 1;
						recursion(copy, n + 1, sum + 1);
						stock[i] = stock[i] + 1;
					}
				}
			}

		} else {
			recursion(array, n + 1, sum);
		}
	}

	public boolean isCover(int paper[][], int x, int y, int n) {
		if (x + n > 10 || y + n > 10 || stock[n] == 0)
			return false;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (paper[y + i][x + j] == 0)
					return false;
			}
		}

		return true;
	}

	public int[][] cover(int array[][], int x, int y, int n) {
		int paper[][] = copy(array);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				paper[y + i][x + j] = 0;
			}
		}

		return paper;
	}

	public int[][] copy(int array[][]) {
		int copy[][] = new int[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				copy[i][j] = array[i][j];
			}
		}

		return copy;
	}
}