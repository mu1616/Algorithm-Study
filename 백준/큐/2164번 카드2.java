import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		Queue<Integer> queue = new LinkedList<>();

		if (n == 1) {
			System.out.println("1");
			return;
		}
		
		for (int i = 1; i <= n; i++)
			queue.offer(i);

		while (true) {
			queue.poll();

			if (queue.size() == 1) {
				break;

			} else {
				queue.offer(queue.poll());
			}
		}

		System.out.println(queue.peek());
	}

}