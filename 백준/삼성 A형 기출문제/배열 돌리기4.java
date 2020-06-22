import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int array[][];
	int answer = 99999999;

	public static void main(String[] args) {
		Main main = new Main();

		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int m = scan.nextInt();
		int k = scan.nextInt();
		array = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				array[i][j] = scan.nextInt();
			}
		}

		Rotation rotations[] = new Rotation[k];
		for (int i = 0; i < k; i++) {
			rotations[i] = new Rotation(scan.nextInt(), scan.nextInt(), scan.nextInt());
		}

		permu(rotations, 0, rotations.length);

		System.out.println(answer);
	}

	public void permu(Rotation rotations[], int start, int r) {
		if (r == 0) {
			int copy[][] = copy(array);
			
			for (int i = 0; i < rotations.length; i++) {
				int x = rotations[i].c - rotations[i].s - 1;
				int y = rotations[i].r - rotations[i].s - 1;
				int len = (rotations[i].s * 2) + 1;
				rotate(copy, x, y, len);
			}

			int min = getMin(copy);

			if (answer > min)
				answer = min;
		} else {
			for (int i = start; i < rotations.length; i++) {
				swap(rotations, i, start);
				permu(rotations, start + 1, r - 1);
				swap(rotations, i, start);
			}
		}
	}

	public int getMin(int array[][]) {
		int min = 9999999;

		for (int i = 0; i < array.length; i++) {
			int sum = 0;
			for (int j = 0; j < array[0].length; j++) {
				sum += array[i][j];
			}
			if (sum < min)
				min = sum;
		}

		return min;
	}

	public void swap(Rotation rotations[], int i, int j) {
		Rotation tmp = rotations[i];
		rotations[i] = rotations[j];
		rotations[j] = tmp;
	}

	public void rotate(int array[][], int x, int y, int len) {
		if (len <= 1) {
			return;
		}
		int tmp1;
		int tmp2;
		tmp1 = array[y][x];
		for (int i = x; i <= x + len - 2; i++) {
			tmp2 = array[y][i + 1];
			array[y][i + 1] = tmp1;
			tmp1 = tmp2;
		}

		for (int i = y; i <= y + len - 2; i++) {
			tmp2 = array[i + 1][x + len - 1];
			array[i + 1][x + len - 1] = tmp1;
			tmp1 = tmp2;
		}

		for (int i = x + len - 1; i >= x + 1; i--) {
			tmp2 = array[y + len - 1][i - 1];
			array[y + len - 1][i - 1] = tmp1;
			tmp1 = tmp2;
		}

		for (int i = y + len - 1; i >= y + 1; i--) {
			tmp2 = array[i - 1][x];
			array[i - 1][x] = tmp1;
			tmp1 = tmp2;
		}

		rotate(array, x + 1, y + 1, len - 2);

	}

	public int[][] copy(int array[][]) {
		int copy[][] = new int[array.length][array[0].length];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				copy[i][j] = array[i][j];
			}
		}
		return copy;
	}

	public void printArray(int array[][]) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	class Rotation {
		int r;
		int c;
		int s;

		Rotation(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}

}