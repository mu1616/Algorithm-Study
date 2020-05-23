import java.util.*;
class Solution {
		
	public int solution(int n, int[] lost, int[] reserve) {
        int answer;
        ArrayList<Integer> reserveList = new ArrayList<>();
        ArrayList<Integer> lostList = new ArrayList<>();
        for(int i : reserve)
        	reserveList.add(i);
        for(int i : lost)
        	lostList.add(i);
        for(int i=0; i< lost.length; i++) {
        	int tmp = lost[i];
        	if(reserveList.contains(tmp)) {
        		lostList.remove(new Integer(tmp));
        		reserveList.remove(new Integer(tmp));
        	}
        }       
        answer = n - lostList.size();
        System.out.println(answer);
        for(int i=0; i< lostList.size(); i++) {
        	for(int j=0; j< reserveList.size(); j++) {
        		if(lostList.get(i)-1 == reserveList.get(j) || lostList.get(i)+1 == reserveList.get(j)) {
        			answer++;
        			reserveList.remove(j);
        			break;
        		}
        	}
        }
        return answer;
    }
}

//2중포문을 안돌고 할 수 있는 방법은?? https://programmers.co.kr/learn/courses/30/lessons/42862/solution_groups?language=java&type=all
