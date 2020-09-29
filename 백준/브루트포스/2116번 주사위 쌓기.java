import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int max = Integer.MIN_VALUE;
	int n;
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		this.n = n;
		int dices[][] = new int[n][6];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 6; j++) {
				dices[i][j] = scan.nextInt();
			}
		}
		
		for(int i = 1; i <= 6; i++) {
			recursion(i, 0, 0, dices);
		}
		
		System.out.print(max);
	}

	public void recursion(int up, int sum, int depth, int dices[][]) {
		if(depth == n) {
			if(max < sum) max = sum;
			return;
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 6; i++)
			list.add(i);

		int nextDown = 0;
		int nextUp = 0;

		for(int i = 0; i < 6; i++) {
			if(dices[depth][i] == up) nextDown = i;
		}

		switch (nextDown) {
		case 0:
			nextUp = 5;
			break;
		case 1:
			nextUp = 3;
			break;
		case 2:
			nextUp = 4;
			break;
		case 3:
			nextUp = 1;
			break;
		case 4:
			nextUp = 2;
			break;
		case 5:
			nextUp = 0;
			break;
		}
		
		list.remove(new Integer(dices[depth][nextUp]));
		list.remove(new Integer(dices[depth][nextDown]));
		
		recursion(dices[depth][nextUp], sum + list.get(list.size() - 1), depth + 1, dices);
	}
}