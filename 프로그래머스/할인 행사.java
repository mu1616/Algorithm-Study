import java.util.*;

class Solution {
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        for (int i = 0; i < discount.length - 9; i++) {
            Map<String, Integer> discountMap = new HashMap<>();
            for (int j = i; j < i + 10; j++) {
                discountMap.merge(discount[j], 1, (oldValue, value) -> oldValue + 1);
            }
            if (wantMap.equals(discountMap)) {
                answer++;
            }
        }
        return answer;
    }
}