import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        List<Integer> sortedD = Arrays.stream(d)
                .boxed()
                .sorted()
                .collect(Collectors.toList());
        int sum = 0;
        for (int num : sortedD) {
            if (sum + num <= budget) {
                sum = sum + num;
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}