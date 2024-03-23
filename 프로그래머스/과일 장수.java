import java.io.IOException;
import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        List<Integer> sortedScoreList = Arrays.stream(score)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        for (int i = 0 ; i < sortedScoreList.size(); i++) {
            if ((i + 1) % m == 0) {
                answer = answer + (sortedScoreList.get(i) * m);
            }
        }
        return answer;
    }
}