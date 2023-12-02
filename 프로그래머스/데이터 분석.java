import java.util.*;
import java.util.stream.*;

class Solution {

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> dataIndexMap = Map.of(
                "code", 0,
                "date", 1,
                "maximum", 2,
                "remain", 3
        );
        int[][] answer = Arrays.stream(data)
                .filter(aData -> aData[dataIndexMap.get(ext)] < val_ext)
                .sorted(Comparator.comparingInt(aData -> aData[dataIndexMap.get(sort_by)]))
                .toArray(int[][]::new);
        return answer;
    }    
}