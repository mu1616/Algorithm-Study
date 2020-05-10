package algorithm;

import java.util.*;

class Main {
	static int size = 2;   // 몇개를 뽑을 것인가?
	public static void main(String[] args) {
		Main m = new Main();
		String[] array = { "a", "b", "c" ,"d","e"};
		m.permutation(array, 0, size);
	}

	public void permutation(String[] array, int start, int r) {
		if (r == 0) {
			// 0~size 만큼 출력 (array의 0~size인덱스에 뽑은 배열이 들어있음)
			for (int i = 0; i < size; i++) {   
				System.out.print(array[i] + " ");
			}
			System.out.println();
		} else {
			// a를 맨앞에 놓고 재귀, b를 맨앞에놓고 재귀, c를 맨앞에 놓고 재귀 ...
			for (int i = start; i < array.length; i++) {				
				swap(array, start, i); // 스왑 
				permutation(array, start + 1, r-1);
				swap(array, start, i); // 스왑한거 되돌리기
			}
		}
	}

	public void swap(String[] array, int i, int j) {
		String temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}