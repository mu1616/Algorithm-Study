import java.util.*;
class Solution {
    public int solution(String s) {
		int answer = 0;
		ArrayList<Integer> list = new ArrayList<>();
		list.add(s.length());
		for (int i = 1; i <= s.length()/2 ; i++) {
			list.add(findLength(s,i));
		}
		Collections.sort(list);
		answer = list.get(0);
		return answer;
	}
	
	public int findLength(String s, int n) {
		int length = s.length();
		String result = "";
		int count = 1;
		String tmp1 = "";
		String tmp2 = "";
		for(int i=0; i < length/n+1; i++) {
			int start = i*n;
			int end = start + n;
			if(i==0) {
				tmp1 = s.substring(start, end);
				continue;
			}
			if(end > s.length()) {
				result = result + s.substring(start, s.length());
				break;
			}
			
			tmp2 = s.substring(start, end);
			if(tmp1.equals(tmp2)) {
				count++;
			}else {
				if(count >1) 
					result = result + count + tmp1;
				else 
					result = result + tmp1;

				tmp1 = tmp2;
				count = 1;
			}
			
		}
		if(count > 1) {
			result = result + count + tmp1;
		} else {
			result = result + tmp1;
		}
		return result.length();
	}
}