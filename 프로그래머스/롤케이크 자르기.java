import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> map = Arrays.stream(topping)
                .boxed()
                .collect(Collectors.toMap(t -> t, t -> 1, (exist, replace) -> exist + 1));

        Set<Integer> set = new HashSet<>();
        for (int t : topping) {
            set.add(t);
            int count = map.get(t);
            if (count > 1) {
                map.put(t, count - 1);
            } else {
                map.remove(t);
            }
            if (map.size() == set.size()) {
                answer++;
            }
        }
        return answer;
    }
}