//정확성 통과, 효율성 실패
import java.util.*;
class Solution {

	HashMap<Integer, Integer> map = new HashMap<>();
	public int solution(int[] stones, int k) {
		int answer = 0;
		// map.put(stones.length - 1, -1);
		boolean complete = true;
		while (true) {
			for (int i = 0; i < stones.length; i++) {
				if (map.containsKey(i)) {
					int diff = map.get(i) - i;
					if (diff >= k) {
						complete = false;
					} else {
						i = i + (diff - 1);
						continue;
					}
				}
				stones[i] = stones[i] - 1;
				if (stones[i] == 0) {
					linkNode(i, stones);
				}
			}
			if (complete == false)
				break;
			if (complete == true)
				answer++;
		}	
		return answer;
	}

	void linkNode(int n, int[] stones) {
		// 오른쪽 검사

		if (map.containsKey(n + 1)) {
			map.put(n, map.get(n + 1));
		}
		// 왼쪽 검사
		int destNode;
		if(map.containsKey(n)) {
			destNode = map.get(n);
		} else {
			destNode = n+1;
		}
		while (true) {
			if (n!=0 && stones[n-1]==0) {
				n--;
			} else {
				break;
			}
		}
		map.put(n, destNode);
	}
}