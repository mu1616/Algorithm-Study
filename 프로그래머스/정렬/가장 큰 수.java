import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<Integer> list = new ArrayList<>();
        for(int n : numbers)
        	list.add(n);
        
        Collections.sort(list, new Sorting());
        for(int n : list){
        	answer = answer + Integer.toString(n);
        }
        if(answer.charAt(0)=='0') answer="0";
        return answer;
    }

	class Sorting implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			String a = Integer.toString(o1);
			String b = Integer.toString(o2);
			if(Integer.parseInt(a+b) > Integer.parseInt(b+a)) {
				return -1;
			}else if(Integer.parseInt(a+b) < Integer.parseInt(b+a)){
				return 1;
			}else {
				return 0;
			}

		}
	}
}