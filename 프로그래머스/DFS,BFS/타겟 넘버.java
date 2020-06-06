import java.util.*;
class Solution {
    	ArrayList<Integer> list;
	Stack<Integer> stack = new Stack<>();
	int result;


	public int solution(int[] numbers, int target) {
        int answer = 0;
        list = new ArrayList<>();
        for(int i=0; i< numbers.length; i++) {
        	list.add(numbers[i]);
        }
        recursion(0, 0, target);
       	answer = result;
        return answer;
    }
	
	public void recursion(int start, int sum, int target) {
		if(start==list.size()) {
			if(sum == target) result++;
			return;
		}
		recursion(start+1, sum+list.get(start),target);
		recursion(start+1, sum-list.get(start),target);
	}
}