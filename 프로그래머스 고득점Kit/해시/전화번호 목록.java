import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, phone_book);
        for(int i=0; i< phone_book.length; i++) {
        	for(int j=0; j< phone_book[i].length()-1; j++) {
        		String tmp = phone_book[i].substring(0,j+1);
        		if(set.contains(tmp)) {
        			answer = false;
        		}
        	}
        }
        return answer;
    }
	
}