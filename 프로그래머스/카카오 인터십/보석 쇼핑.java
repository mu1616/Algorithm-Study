import java.util.*;
class Solution {
    HashMap<String, Integer> map = new HashMap<>();

    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();

        for(String str : gems)
            set.add(str);

        int gemCnt = set.size();
        int front = 0;
        int end = 0;

        for(int i = 0; i< gems.length; i++) {
            if(!map.containsKey(gems[i])) {
                map.put(gems[i], 1);
            } else {
                map.replace(gems[i], map.get(gems[i]) + 1);
            }

            if(map.size() == gemCnt) {
                end = i;
                break;
            }
        }

        answer[0] = front + 1;
        answer[1] = end + 1;

        while(end < gems.length) { 

            for(int i = front; i<= end; i++) {
                int cnt = map.get(gems[i]);

                if(cnt == 1) {
                    front = i;
                    break;

                } else {
                    map.replace(gems[i], cnt - 1);
                }
            }

            if(answer[1] - answer[0] > end - front) {
                answer[0] = front + 1;
                answer[1] = end + 1;
            }

            end++;

            if(end != gems.length) 
                map.replace(gems[end], map.get(gems[end]) + 1);         
        }

        return answer;
    }
}