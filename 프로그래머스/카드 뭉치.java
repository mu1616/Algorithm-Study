import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> queue1 = Arrays.stream(cards1).collect(Collectors.toCollection(LinkedList::new));
        Queue<String> queue2 = Arrays.stream(cards2).collect(Collectors.toCollection(LinkedList::new));
        for (int i = 0; i < goal.length; i++) {
            if (!queue1.isEmpty() && queue1.peek().equals(goal[i])) {
                queue1.poll();
                continue;
            }
            if (!queue2.isEmpty() && queue2.peek().equals(goal[i])) {
                queue2.poll();
                continue;
            }
            return "No";
        }
        return "Yes";
    }
}