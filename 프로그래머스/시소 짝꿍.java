import java.util.*;

class Solution {
    
    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Integer> map = new HashMap<>();
        Arrays.sort(weights);
        for (int i = 0; i < weights.length; i++) {
            answer = answer + map.getOrDefault((double) weights[i], 0);
            answer = answer + map.getOrDefault((double) weights[i] / 2, 0);
            answer = answer + map.getOrDefault((double) weights[i] / 3 * 2, 0);
            answer = answer + map.getOrDefault((double) weights[i] / 4 * 3, 0);
            map.put((double) weights[i], map.getOrDefault((double) weights[i], 0) + 1);
        }
        return answer;
    }
}   