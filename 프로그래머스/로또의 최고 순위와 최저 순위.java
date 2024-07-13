import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> winNumSet = Arrays.stream(win_nums)
                .boxed()
                .collect(Collectors.toSet());

        int max = 0;
        int min = 0;
        for (int num : lottos) {
            if (winNumSet.contains(num)) {
                max++;
                min++;
                continue;
            }
            if (num == 0) {
                max++;
            }
        }

        return new int[]{Math.min(6, 7 - max), Math.min(6, 7 - min)};
    }
}