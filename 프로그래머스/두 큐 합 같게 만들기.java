import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> queue1List = new LinkedList<>();
        Queue<Integer> queue2List = new LinkedList<>();
        for (int i = 0 ; i < queue1.length; i++) {
            queue1List.add(queue1[i]);
            queue2List.add(queue2[i]);
        }
        long  queue1Sum = queue1List.stream().mapToInt(n -> n).sum();
        long queue2Sum = queue2List.stream().mapToInt(n -> n).sum();
        if ((queue1Sum + queue2Sum) % 2 != 0) {
            return -1;
        }
        long target = (queue1Sum + queue2Sum) / 2;

        int cnt = 0;
        while (cnt < queue1.length * 2 * 2) {
            if (queue1Sum == target) {
                return cnt;
            }
            if (queue1Sum < target) {
                queue1Sum = queue1Sum + queue2List.peek();
                queue2Sum = queue2Sum - queue2List.peek();
                queue1List.add(queue2List.poll());
            } else {
                queue1Sum = queue1Sum - queue1List.peek();
                queue2Sum = queue2Sum + queue1List.peek();
                queue2List.add(queue1List.poll());
            }
            cnt++;
        }
        return -1;
    }
}