import java.util.*;

class Solution {
    
    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            answer = calc(answer, arr[i + 1]);
        }
        return answer;
    }

    private int calc(int n1, int n2) {
        Set<Integer> n1MultipleSet = new HashSet<>();
        for (int i = 1; i <= n2; i++) {
            n1MultipleSet.add(n1 * i);
        }
        for (int i = 1; i <= n1; i++) {
            if (n1MultipleSet.contains(n2 * i)) {
                return n2 * i;
            }
        }
        throw new IllegalStateException();
    }
}