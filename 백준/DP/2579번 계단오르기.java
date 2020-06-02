import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int array[] = new int[n + 1];
		for (int i = 1; i < array.length; i++) {
			array[i] = scan.nextInt();
		}
		int dp1[] = new int[n + 1]; // 해당 위치에서 얻을 수 있는 최대점수
		dp1[1] = array[1];
		if (n >= 2) {
			dp1[2] = array[2] + array[1];
			if (n >= 3) {
				if (array[1] > array[2]) {
					dp1[3] = array[1] + array[3];
				} else {
					dp1[3] = array[2] + array[3];
				}
			}
		}

		for (int i = 4; i < n + 1; i++) {
			dp1[i] = Math.max(dp1[i - 2] + array[i], dp1[i - 3] + array[i - 1] + array[i]);
		}
		System.out.println(dp1[n]);
	}

}