import java.util.*;

class Solution {

    public int solution(int x, int y, int n) {
        Queue<Value> queue = new LinkedList<>();
        Set<Integer> visitedSet = new HashSet<>();
        queue.add(new Value(x, 0));

        while (!queue.isEmpty()) {
            Value currentValue = queue.poll();
            if (currentValue.num == y) {
                return currentValue.count;
            }
            int nextNum1 = currentValue.num + n;
            if (nextNum1 <= y && !visitedSet.contains(nextNum1)) {
                queue.add(new Value(nextNum1, currentValue.count + 1));
                visitedSet.add(nextNum1);
            }
            int nextNum2 = currentValue.num * 2;
            if (nextNum2 <= y && !visitedSet.contains(nextNum2)) {
                queue.add(new Value(nextNum2, currentValue.count + 1));
                visitedSet.add(nextNum2);
            }
            int nextNum3 = currentValue.num * 3;
            if (nextNum3 <= y && !visitedSet.contains(nextNum3)) {
                queue.add(new Value(nextNum3, currentValue.count + 1));
                visitedSet.add(nextNum3);
            }
        }
        return -1;
    }

    public class Value {
        int num;
        int count;

        public Value(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}