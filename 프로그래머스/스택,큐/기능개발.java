import java.util.*;
class Solution {
public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        ArrayList<Integer> list = new ArrayList<>();
        int front = 0;
        while(front!=progresses.length) {
        	for(int i=0; i< progresses.length; i++) {
        		progresses[i] = progresses[i] + speeds[i];
        	}
        	if(progresses[front]>=100){
        		int cnt = 0;
        		for(int i=front; i< progresses.length; i++) {
        			if(progresses[front]>=100) {
        				cnt++;
        				front++;
        			} else {
        				break;
        			}
        		}
        		list.add(cnt);
        	}
        }
        answer = new int[list.size()];
            for(int i=0; i< list.size(); i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
}
