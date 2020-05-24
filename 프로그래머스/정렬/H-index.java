import java.util.*;
class Solution {
   public int solution(int[] citations) {
        int answer = -1;
        Arrays.sort(citations);
        for(int i=0; i<= citations[citations.length-1]; i++) {
        	int sum = 0;
        	for(int j=0; j< citations.length; j++) {
        		if(citations[j] >= i)
        			sum++;
        	}
        	if(sum >=i) {
        		answer = i;
        	} else {
        		break;
        	}
        }
        System.out.println(answer);
        return answer;
    }
}