import java.util.*;
class Solution {

	public int solution(int[] stones, int k) {
		int answer = 0;		
		int left = 1;
		int right = 200000000;
		int mid;
		while(left <= right) {
			mid = (left+right)/2;
			if(complete(mid, stones, k)) {
				left = mid + 1;
				answer = mid;
			}else {
				right = mid - 1;
			}
		}
		return answer;
	}
	
	boolean complete(int mid, int [] stones, int k) {
		int count = 0;
		for(int i=0; i< stones.length; i++) {
			if(stones[i] - mid < 0) {
				count++;
			} else {
				if(count >= k) {
					return false;
				}	
				count = 0;
			}
			if(count >= k) {
				return false;
			}
		}
		return true;
	}
}