import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (t1, t2) -> t1[1] - t2[1]);
        int before = 0;
        for (int[] target : targets) {
            if (target[0] >= before) {
                answer++;
                before = target[1];
            }
        }
        return answer;
    }
}