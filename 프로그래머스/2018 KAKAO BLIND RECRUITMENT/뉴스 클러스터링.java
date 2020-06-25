import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        String compare = "abcdefghijklmnopqrstuvwxyz";
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        
        for(int i=0; i< str1.length()-1; i++) {
        	String a = str1.substring(i, i+2);
        	if(compare.contains(a.substring(0,1)) && compare.contains(a.substring(1, 2))) {
        		list1.add(a);
        	}      	
        }
        
        for(int i = 0; i< str2.length()-1; i++) {
        	String a = str2.substring(i, i+2);
        	if(compare.contains(a.substring(0,1)) && compare.contains(a.substring(1, 2))) {
        		list2.add(a);
        	}     
        }
        
        if(list1.size() == 0 && list2.size() == 0) {
        	answer = 65536;
        	return answer;
        }
        
        ArrayList<String> union = new ArrayList<>();
        boolean visited[] = new boolean[list1.size()];
        
        for(int i=0; i< list2.size(); i++) {
        	for(int j=0; j< list1.size(); j++) {
        		if(!visited[j] && list2.get(i).equals(list1.get(j))) {
        			union.add(list2.get(i));
        			visited[j] = true;
                    break;
        		}
        	}
        }
            
        ArrayList<String> intersection = new ArrayList<>();
        intersection.addAll(list1);
        visited = new boolean[intersection.size()];
        
        l:for(int i=0; i< list2.size(); i++) {
        	for(int j=0; j< list1.size(); j++) {
        		if(!visited[j] && list2.get(i).equals(intersection.get(j))) {
        			visited[j] = true;
        			continue l;
        		}
        	}
        	intersection.add(list2.get(i));
        }

        double similarity = (double)union.size() / (double)intersection.size();
        answer = (int)(similarity * 65536);
        return answer;
    }
}