import java.util.*;

class Solution {
    public int solution(String s) {
        Map<String, Integer> map = Map.of(
                "zero", 0,
                "one", 1,
                "two", 2,
                "three", 3,
                "four", 4,
                "five", 5,
                "six", 6,
                "seven", 7,
                "eight", 8,
                "nine", 9
        );
        for (String str : map.keySet()) {
            s = s.replaceAll(str, String.valueOf(map.get(str)));
        }
        return Integer.parseInt(s);
    }
}