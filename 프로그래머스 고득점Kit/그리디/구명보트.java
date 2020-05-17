import java.util.*;
class Solution {
   public int solution(int[] people, int limit) {
		int i,j;
		int answer = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for (int n : people) {
			list.add(n);
		}
		Collections.sort(list, Collections.reverseOrder());
		j = list.size()-1;
		for(i=0; i< list.size(); i++) {
			if(i>j) break;
			if(i==j) {
				answer++;
				break;
			}
			if(list.get(i) + list.get(j) > limit) {	
				answer++;			
			}else {
				j--;
				answer++;
			}
		}
		
		return answer;
	}
}
	
	