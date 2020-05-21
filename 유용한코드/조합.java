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
	
	//combination2와 알고리즘을 동일하지만 stack 대신 배열 사용
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

	public void combination3(){
		//위에 방법들과 다르게, [1,2,3,4,5]가 있다면
		//1를 뽑았을때 안뽑았을 때 두개로 나눠서 재귀
	}	

}