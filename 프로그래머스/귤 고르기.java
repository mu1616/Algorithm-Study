import java.util.*;

class Solution {

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : tangerine) {
            map.merge(num, 1, (oldValue, value) -> oldValue + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> map.get(n2) - map.get(n1));
        pq.addAll(map.keySet());

        int count = k;
        while (count > 0) {
            int num = pq.poll();
            count = count - map.get(num);
            answer++;
        }
        return answer;
    }
}