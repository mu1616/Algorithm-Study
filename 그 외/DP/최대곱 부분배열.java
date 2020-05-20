import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();

	}


	public void solution() {
		int array[] = { 0,0,0,0,0,5,6,-7,-19};
		int dp1[] = new int[array.length]; // i가 구간의 끝일 때 최대곱
		int dp2[] = new int[array.length]; // 0~i 곱 (단, 중간에 0이 있다면, 그다음요소 ~ i 구간의 곱)
		int minus = 0;

		dp1[0] = array[0];
		dp2[0] = array[0];
		if (array[0] < 0) {
			minus = 1;
		}

		for (int i = 1; i < array.length; i++) {
			if (dp2[i - 1] == 0) {
				dp2[i] = array[i];
			} else {
				dp2[i] = dp2[i - 1] * array[i];
			}
		}
		System.out.print(dp1[0]+" ");
		for (int i = 1; i < array.length; i++) {
			if(dp2[i-1] <0 && array[i] <0) {
				dp1[i] = dp2[i];
			}else {
				dp1[i] = Math.max(dp1[i-1]*array[i], array[i]);
			}
			System.out.print(dp1[i]+" ");
		}
	}

}
