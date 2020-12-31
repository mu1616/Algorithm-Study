import java.util.*;

class Solution {

	public int[] solution(int[] array, int k) {
		if(array.length == 0) {
			return array;
		}
		
		Deque<Integer> deque = new ArrayDeque<Integer>();
		for (int num : array) {
			deque.offerLast(num);
		}
		
		for(int i = 0; i < k; i++) {
			int tmp = deque.pollLast();
			deque.offerFirst(tmp);
		}
		
		int i = 0;
		while(!deque.isEmpty()) {
			array[i++] = deque.pollFirst();
		}
		
		return array;
	}
}