import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < numbers.length - 1; i++) {
            stack.push(i);
            while(!stack.isEmpty()) {
                int idx = stack.peek();
                if (numbers[idx] < numbers[i + 1]) {
                    answer[idx] = numbers[i + 1];
                    stack.pop();
                } else {
                    break;
                }
            }
        }
        return answer;
    }
}