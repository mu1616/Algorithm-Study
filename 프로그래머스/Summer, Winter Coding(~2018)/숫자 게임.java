import java.util.*;

class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        
        int p = 0;
        
        for(int i = 0; i < a.length; i++) {
        	int n = a[i];
        	
        	while(p < b.length) {
        		if(b[p] > n) {
        			answer++;
        			p++;
        			break;
        			
        		} else {
        			p++;
        		}
        	}
        	
        	if(p >= b.length)
        		break;
        }
        
        //System.out.print(answer);
        return answer;
    }
}