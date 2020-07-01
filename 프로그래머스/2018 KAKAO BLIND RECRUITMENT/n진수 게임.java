import java.util.*;

class Solution {
	String num[] = new String[16];    
    
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        for(int i=0; i< 10; i++)
        	num[i] = String.valueOf(i);       
        num[10] = "A";
        num[11] = "B";
        num[12] = "C";
        num[13] = "D";
        num[14] = "E";
        num[15] = "F";
    
        ArrayList<String> resultList = new ArrayList<>();
        
        int i = 0;
        int turn = 1;

        l:while(turn <= t * m) {
        	String str = toSpecificNumber(n, i);

        	for(int j = 0; j< str.length(); j++) {
        		if(turn % m == p || (turn % m == 0 && m == p))
        			resultList.add(str.substring(j, j + 1));  
        		
        		if(resultList.size() == t)
        			break l;
        		
        		turn++;
        	}
        	
        	i++;
        }
        
        StringBuilder sb = new StringBuilder("");
        
        for(String s : resultList)
        	sb.append(s);
        
        answer = sb.toString();
        
        return answer;
    }
    
    public String toSpecificNumber(int n, int i) {
    	if(i == 0)
    		return "0";
    	
    	StringBuilder sb = new StringBuilder("");

    	int a = i;
    	while(true) {
    		if(a / n == 0) {
    			sb.insert(0, num[a % n]);
    			break;
    		}
    		
    		sb.insert(0, num[a % n]);
    		a = a / n;
    	}
    	
    	return sb.toString();    			
    }
}