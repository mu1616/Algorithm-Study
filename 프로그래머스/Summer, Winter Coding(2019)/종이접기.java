import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[] answer;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        
        ArrayList<Integer> tmp = new ArrayList<>();
        
        for(int i = 1; i< n; i++) {
        	tmp.clear();
        	for(int j = 0; j< list.size(); j++) {
        		if(j % 2 == 0) {
        			tmp.add(0);
        			tmp.add(list.get(j));
        			tmp.add(1);
        		} else {
        			tmp.add(list.get(j));
        		}
        	}
        	list.clear();
        	list.addAll(tmp);
        }
        
        answer = new int[list.size()];
        
        
        for(int i = 0; i< answer.length; i++)
        	answer[i] = list.get(i);
        
        return answer;
    }
}