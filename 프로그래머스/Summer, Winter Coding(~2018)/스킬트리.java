import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        Queue<String> tmp = new LinkedList<>();
        
        for(int i=0; i< skill.length(); i++)
        	queue.offer(skill.substring(i, i + 1));
        
        l:for(int i=0; i< skill_trees.length; i++) {
        	tmp.clear();
        	tmp.addAll(queue);
        	String currTree = skill_trees[i];

        	for(int j = 0; j< currTree.length(); j++) {
        		String currSkill = currTree.substring(j, j + 1);

        		if(tmp.contains(currSkill)) {
        			if(tmp.peek().equals(currSkill)) { //현재 배울 수 있는 스킬이라면
        				tmp.poll();
        				
        			} else {   // 현재 배울 수 없는 스킬이라면
        				continue l;
        			}
        			
        		} else {  //스킬트리에 포함된 스킬이 아니라면
        			continue;
        		}
        	}
        	answer++;
        }
        
        
        return answer;
    }
}