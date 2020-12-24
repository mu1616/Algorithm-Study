package algorithm;

import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	Deque<Integer> deque = new ArrayDeque<>();
	static final int LEFT = 1;
	static final int RIGHT = 2;
	
	public static void main(String[] args) {
		Main main = new Main();
		int t = scan.nextInt();
		for (int i = 0; i < t; i++)
			main.solution();
	}

	public void solution() {
		deque.clear();
		String command = scan.next();
		int n = scan.nextInt();
		String numbers = scan.next();
		numbers = numbers.replace("[", "");
		numbers = numbers.replace("]", "");
		String numArray[] = numbers.split(",");

		if (!numbers.equals("")) {
			for (int i = 0; i < numArray.length; i++) {
				deque.addLast(Integer.parseInt(numArray[i]));
			}
		}

		int start = LEFT;
		
		for (int i = 0; i < command.length(); i++) {
			char func = command.charAt(i);
			boolean isComplete = true;

			if (func == 'R') {
				start = (start == LEFT) ? RIGHT : LEFT;
			} else {
				isComplete = D(start);
			}
			
			if (!isComplete) {
				System.out.println("error");
				return;
			}
		}

		if (deque.isEmpty()) {
			System.out.println("[]");
			return;
		}
		
		StringBuilder answer = new StringBuilder("");
		answer.append("[");

		while(!deque.isEmpty()) {
			if (start == LEFT) {
				answer.append(deque.pollFirst());
			} else {
				answer.append(deque.pollLast());
			}

			answer.append(",");
		}

		answer = new StringBuilder(answer.substring(0, answer.length() - 1));
		answer.append("]");

		System.out.println(answer.toString());
	}

	public boolean D(int start) {
		if (deque.isEmpty()) {
			return false;
		}

		if(start == LEFT) {
			deque.removeFirst();
		} else {
			deque.removeLast();
		}
		return true;
	}

}