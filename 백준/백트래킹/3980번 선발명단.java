import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	boolean visited[] = new boolean[11];
	int max = 0;

	public static void main(String[] args) {
		Main main = new Main();
		int c = scan.nextInt();
		for (int i = 0; i < c; i++)
			main.solution();
	}

	public void solution() {
		max = 0;
		int array[][] = new int[11][11];
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				array[i][j] = scan.nextInt();
			}
		}

		recursion(array, 0, 0, 0);
		System.out.println(max);
	}

	public void recursion(int array[][], int curr, int depth, int sum) {
		if (depth == 11) {
			max = Math.max(max, sum);
			return;
		}

		for (int j = 0; j < 11; j++) {
			if (!visited[j] && array[curr][j] > 0) {
				visited[j] = true;
				recursion(array, curr + 1, depth + 1, sum + array[curr][j]);
				visited[j] = false;
			}
		}
	}
}
