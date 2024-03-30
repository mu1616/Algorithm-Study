import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] food) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(0);
        for (int i = food.length - 1; i > 0; i--) {
            int cnt = food[i] % 2 == 0 ? food[i] : food[i] - 1;
            for (int j = 0; j < cnt / 2; j++) {
                deque.addFirst(i);
                deque.addLast(i);
            }
        }
        return deque.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}