import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public int solution(int[] number) {
        AtomicInteger answer = new AtomicInteger(0);
        recursive(number, 0, 3, 0, answer);
        return answer.get();
    }

    private void recursive(int[] number, int start, int r, int sum, AtomicInteger answer) {
        if (r == 0) {
            if (sum == 0) {
                answer.addAndGet(1);
            }
            return;
        }
        for (int i = start; i < number.length; i++) {
            sum = sum + number[i];
            recursive(number, i + 1, r - 1, sum, answer);
            sum = sum - number[i];
        }
    }
}