//정확성 통과, 효율성 실패
import java.util.*;
class Solution {
    static HashMap<Long,Long> map = new HashMap<>();
	
	public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        for(int i=0; i< room_number.length; i++) {
        	if(map.containsKey(room_number[i])) {
        		long node = find(room_number[i]);
        		map.put(node, node+1);
        		answer[i] = node;
        	}else {      	
        		map.put(room_number[i],room_number[i]+1);
        		answer[i] = room_number[i];
        	}
        }
        return answer;
    }
    
	public long find(long i) {
		while(true) {
			if(map.containsKey(i)) {
				i++;
			}else {
                return i;
			}
		}
	}
}