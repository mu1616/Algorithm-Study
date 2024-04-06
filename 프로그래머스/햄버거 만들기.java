import java.util.*;

class Solution {
    public static final int BREAD = 1;
    public static final int VEGETABLE = 2;
    public static final int MEAT = 3;
    
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i : ingredient) {
            stack.push(i);
            if (stack.size() < 4) {
                continue;
            }
            int i1 = stack.pop();
            int i2 = stack.pop();
            int i3 = stack.pop();
            int i4 = stack.pop();
            if (i1 == BREAD && i2 == MEAT && i3 == VEGETABLE && i4 == BREAD) {
                answer++;
            } else {
                stack.push(i4);
                stack.push(i3);
                stack.push(i2);
                stack.push(i1);
            }
        }
        return answer;
    }
}