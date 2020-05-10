package algorithm;

import java.util.*;

class Main {
	static int size = 2; // 몇개를 뽑을 것인가?
	Stack<String> stack = new Stack<>();
	public static void main(String[] args) {
		Main m = new Main();
		String[] array = { "a", "b", "c", "d", "e" };
		m.combination(array, 0, size);
	}

	public void combination(String[] array, int start, int r) {
		if (r == 0) {
			for (String s : stack) {
				System.out.print(s + " ");
			}
			System.out.println();
		} else {
			//a를 뽑고 재귀, b를뽑고재귀, c를 뽑고 재귀 ....
			for (int i = start; i < array.length; i++) {
				stack.push(array[i]);   //뽑고 스택에 저장
				combination(array, i+1, r - 1);
				stack.pop();   //스택 원상태로
			}
		}
	}

}