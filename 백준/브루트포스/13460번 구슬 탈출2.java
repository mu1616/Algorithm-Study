
import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	char array[][];
	boolean visited[][];

	public static void main(String[] args) {
		Main main = new Main();

		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int m = scan.nextInt();
		array = new char[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String str = scan.next();
			for (int j = 0; j < m; j++) {
				array[i][j] = str.charAt(j);
				if (array[i][j] == '#')
					visited[i][j] = true;
			}
		}
		bfs();

	}

	public void bfs() {
		Queue<Node> queue = new LinkedList<>();
		Node node = new Node();
		node.cnt = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (array[i][j] == 'R') {
					node.row1 = i;
					node.col1 = j;
				}
				if (array[i][j] == 'B') {
					node.row2 = i;
					node.col2 = j;
				}
			}
		}
		queue.offer(node);
		Node curr = null;
		while (!queue.isEmpty()) {
			curr = queue.poll();
			// System.out.println(curr);
			if (curr.cnt >= 10) {
				System.out.println("-1");
				return;
			}
			// 왼쪽
			if (left(queue, curr)) {
				System.out.println(curr.cnt + 1);
				return;
			}
			;
			// 오른쪽
			if (right(queue, curr)) {
				System.out.println(curr.cnt + 1);
				return;
			}
			// 위
			if (up(queue, curr)) {
				System.out.println(curr.cnt + 1);
				return;
			}
			// 아래
			if (down(queue, curr)) {
				System.out.println(curr.cnt + 1);
				return;
			}
		}
		if (curr.end) {
			System.out.println("-1");
			return;
		}
	}

	public boolean down(Queue<Node> queue, Node curr) {
		boolean result = false;
		Node next = new Node();
		next.cnt = curr.cnt + 1;
		next.col1 = curr.col1;
		next.col2 = curr.col2;

		if (curr.row1 < curr.row2) { // R이 B보다 위에 있다면
			for (int i = curr.row2; i < array.length; i++) {
				if (array[i][curr.col2] == '#') {
					next.row2 = i - 1;
					break;
				}
				if (array[i][curr.col2] == 'O') {
					curr.end = true;
					return false;
				}

			}
			for (int i = curr.row1; i < array.length; i++) {
				if (array[i][curr.col1] == 'O') {
					result = true;
				}
				if (array[i][curr.col1] == '#' || (curr.col1 == curr.col2 && i == next.row2)) {
					next.row1 = i - 1;
					break;
				}
			}
		} else { // B가 R보다 위에 있다면
			for (int i = curr.row1; i < array.length; i++) {
				if (array[i][curr.col1] == 'O')
					result = true;
				if (array[i][curr.col1] == '#') {
					next.row1 = i - 1;
					break;
				}
			}
			for (int i = curr.row2; i < array.length; i++) {
				if (array[i][curr.col2] == 'O') {
					curr.end = true;
					return false;
				}
				if (array[i][curr.col2] == '#' || (curr.col1 == curr.col2 && i == next.row1)) {
					next.row2 = i - 1;
					break;
				}
			}
		}
		if (!((curr.row1 == next.row1 && curr.col1 == next.col1) && curr.row2 == next.row2 && curr.col2 == next.col2)) {
			queue.offer(next);
			//System.out.println(next + "d");
		}
		return result;
	}

	public boolean up(Queue<Node> queue, Node curr) {
		boolean result = false;
		Node next = new Node();
		next.cnt = curr.cnt + 1;
		next.col1 = curr.col1;
		next.col2 = curr.col2;

		if (curr.row1 < curr.row2) { // R이 B보다 위에 있다면
			for (int i = curr.row1; i >= 0; i--) {
				if (array[i][curr.col1] == 'O') {
					result = true;
				}
				if (array[i][curr.col1] == '#') {
					next.row1 = i + 1;
					break;
				}
			}
			for (int i = curr.row2; i >= 0; i--) {
				if (array[i][curr.col2] == 'O') {
					curr.end = true;
					return false;
				}
				if (array[i][curr.col2] == '#' || (curr.col1 == curr.col2 && i == next.row1)) {
					next.row2 = i + 1;
					break;
				}
			}
		} else { // B가 R보다 위에 있다면
			for (int i = curr.row2; i >= 0; i--) {
				if (array[i][curr.col2] == 'O') {
					curr.end = true;
					return false;
				}
				if (array[i][curr.col2] == '#') {
					next.row2 = i + 1;
					break;
				}
			}
			for (int i = curr.row1; i >= 0; i--) {
				if (array[i][curr.col1] == 'O') {
					result = true;
				}
				if (array[i][curr.col1] == '#' || (curr.col1 == curr.col2 && i == next.row2)) {
					next.row1 = i + 1;
					break;
				}
			}
		}
		if (!(curr.row1 == next.row1 && curr.col1 == next.col1 && curr.row2 == next.row2 && curr.col2 == next.col2)) {
			queue.offer(next);
			//System.out.println(next + "u");
		}

		return result;
	}

	public boolean right(Queue<Node> queue, Node curr) {
		boolean result = false;
		Node next = new Node();
		next.cnt = curr.cnt + 1;
		next.row1 = curr.row1;
		next.row2 = curr.row2;
		if (curr.col1 < curr.col2) { // R이 B보다 더 왼쪽에 있다면
			for (int i = curr.col2; i < array[0].length; i++) {
				if (array[curr.row2][i] == 'O') {
					curr.end = true;
					return false;
				}
				if (array[curr.row2][i] == '#') {
					next.col2 = i - 1;
					break;
				}
			}
			for (int i = curr.col1; i < array[0].length; i++) {
				if (array[curr.row1][i] == 'O')
					result = true;
				if (array[curr.row1][i] == '#' || (next.row1 == next.row2 && i == next.col2)) {
					next.col1 = i - 1;
					break;
				}
			}
		} else { // B가 R보다 더 왼쪽에 있다면
			for (int i = curr.col1; i < array[0].length; i++) {
				if (array[curr.row1][i] == 'O')
					result = true;
				if (array[curr.row1][i] == '#') {
					next.col1 = i - 1;
					break;
				}
			}
			for (int i = curr.col2; i < array[0].length; i++) {
				if (array[curr.row2][i] == 'O') {
					curr.end = true;
					return false;
				}
				if (array[curr.row2][i] == '#' || (next.row1 == next.row2 && i == next.col1)) {
					next.col2 = i - 1;
					break;
				}
			}
		}
		if (!(curr.row1 == next.row1 && curr.col1 == next.col1 && curr.row2 == next.row2 && curr.col2 == next.col2)) {
			queue.offer(next);
			//System.out.println(next + "r");
		}
		return result;
	}

	public boolean left(Queue<Node> queue, Node curr) {
		boolean result = false;
		Node next = new Node();
		next.cnt = curr.cnt + 1;
		next.row1 = curr.row1;
		next.row2 = curr.row2;
		if (curr.col1 < curr.col2) { // R이 B보다 더 왼쪽에 있다면
			for (int i = curr.col1; i >= 0; i--) {
				if (array[curr.row1][i] == 'O')
					result = true;
				if (array[curr.row1][i] == '#') {
					next.col1 = i + 1;
					break;
				}
			}
			for (int i = curr.col2; i >= 0; i--) {
				if (array[curr.row2][i] == 'O') {
					curr.end = true;
					return false;
				}
				if (array[curr.row2][i] == '#' || (next.row1 == next.row2 && i == next.col1)) {
					next.col2 = i + 1;
					break;
				}
			}
		} else { // B가 R보다 더 왼쪽에 있다면
			for (int i = curr.col2; i >= 0; i--) {
				if (array[curr.row2][i] == 'O') {
					curr.end = true;
					return false;
				}
				if (array[curr.row2][i] == '#') {
					next.col2 = i + 1;
					break;
				}
			}
			for (int i = curr.col1; i >= 0; i--) {
				if (array[curr.row1][i] == 'O')
					result = true;
				if (array[curr.row1][i] == '#' || (next.row1 == next.row2 && i == next.col2)) {
					next.col1 = i + 1;
					break;
				}
			}
		}
		if (!(curr.row1 == next.row1 && curr.col1 == next.col1 && curr.row2 == next.row2 && curr.col2 == next.col2)) {
			queue.offer(next);
			//System.out.println(next + "l");
		}
		return result;
	}

	class Node {
		int row1;
		int col1;
		int row2;
		int col2;
		int cnt = 0;
		boolean end = false;

		Node() {
		}

		Node(int row1, int col1, int row2, int col2) {
			this.row1 = row1;
			this.col1 = col1;
			this.row2 = row2;
			this.col2 = col2;
		}

		@Override
		public String toString() {
			return "Node [row1=" + row1 + ", col1=" + col1 + ", row2=" + row2 + ", col2=" + col2 + ", cnt=" + cnt + "]";
		}

	}

}