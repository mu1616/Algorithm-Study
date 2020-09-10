import java.util.*;
class Solution {
    
        public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        
        for(int i = 0; i < queries.length; i++) {
        	String query = queries[i];
        	int cnt = 0;
        	
        	for(int j = 0; j < words.length; j++) {
        		String word = words[j];
        		if(query.length() != word.length()) {
        			continue;
        		}
        		
        		boolean possible = true;
        		for(int k = 0; k < word.length(); k++) {
        			if(query.charAt(k) != '?' && query.charAt(k) != word.charAt(k)) {
        				possible = false;
        				break;
        			} 
        		}
        		
        		if(possible) {
        			cnt++;
        		}
        	}
        	
        	answer[i] = cnt;
        }
        
        return answer;
    }
}