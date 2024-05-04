import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    public String solution(String X, String Y) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String s : Y.split("")) {
            int n = Integer.parseInt(s);
            map.merge(n, 1, (oldValue, newValue) -> oldValue + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (String s : X.split("")) {
            int n = Integer.parseInt(s);
            Integer count = map.get(n);
            if (count != null && count > 0) {
                map.put(n, count - 1);
                list.add(n);
            }
        }
        Collections.sort(list, Comparator.comparing(n -> n, Comparator.reverseOrder()));
        if (list.isEmpty()) {
            return "-1";
        }
        if (list.get(0) == 0) {
            return "0";
        }
        return list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}