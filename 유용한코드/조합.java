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

	public void combination1(String[] array, int start, int r) {
		if (r == 0) {
			for (String s : stack) {
				System.out.print(s + " ");
			}
			System.out.println();
		} else {
			//a를 뽑고 재귀, b를뽑고재귀, c를 뽑고 재귀 ....
			for (int i = start; i < array.length; i++) {
				stack.push(array[i]);   //뽑고 스택에 저장
				combination(array, i+1, r - 1);    //start+1이 아니라 i+1임!! 순열과 다른점!!!
				stack.pop();   //스택 원상태로
			}
		}
	}
	
	
	int tmp[]
	public void combination2(int []array, int start, int r) {
		if(r==0) {
			for(int n : tmp) {
				System.out.print(n+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start; i< array.length; i++) {
			tmp[6-r] = array[i];
			combination(array, i+1, r-1);
		}
	}	

}