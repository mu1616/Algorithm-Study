import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();

	}

	public void solution() {
		int n = scan.nextInt();
		int m = scan.nextInt();
		int table[][] = new int[n][n];
		for (int i = 0; i < m; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			table[x - 1][y - 1] = 1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				if (i == 0) {
					table[i][j] += table[i][j - 1];
				} else if (j == 0) {
					table[i][j] += table[i - 1][j];
				} else {
					table[i][j] += Math.max(table[i][j - 1], table[i - 1][j]);
				}

			}
		}

		System.out.println(table[n-1][n-1]);

	}

}
