import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < order.length; i++) {
            queue.offer(i + 1);
        }
        int targetOrderIndex = 0;
        while (!queue.isEmpty()) {
            int n = queue.peek();
            if (n == order[targetOrderIndex]) {
                queue.poll();
                answer++;
                targetOrderIndex++;
                continue;
            }
            if (!stack.isEmpty() && stack.peek() == order[targetOrderIndex]) {
                stack.pop();
                answer++;
                targetOrderIndex++;
                continue;
            }
            queue.poll();
            stack.push(n);
        }
        while (!stack.isEmpty() && stack.peek() == order[targetOrderIndex]) {
            stack.pop();
            answer++;
            targetOrderIndex++;
        }
        return answer;
    }
}