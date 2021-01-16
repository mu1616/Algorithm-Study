import java.util.*;

class Solution {
    public int solution(int[] arr) {
    	HashSet<Integer> set = new HashSet<>();
        int answer = 0;
        
        for (int i = 0; i < arr.length; i++) {
        	if (set.contains(arr[i])) {
        		set.remove(arr[i]);
        	} else {
        		set.add(arr[i]);
        	}
        }
        
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
        	answer = it.next();
        }

        return answer;
    }
}