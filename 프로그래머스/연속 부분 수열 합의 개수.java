
import java.util.*;

class Solution {
    
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[][] dp = new int[elements.length][elements.length + 1];
        for (int length = 1; length <= elements.length; length++) {
            for (int i = 0; i < elements.length; i++) {
                int lastIndex = (i + length - 1) % elements.length;
                dp[i][length] = dp[i][length - 1] + elements[lastIndex];
                set.add(dp[i][length]);
            }
        }
        return set.size();
    }
}