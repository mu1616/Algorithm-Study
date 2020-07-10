import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);

            if(a == '(') {
                stack.push(1);

            } else if(a == ')') {
                if(stack.isEmpty()) {
                    answer = false;
                    break;

                } else {
                    stack.pop();
                }
            }
        }

        if(!stack.isEmpty())
            answer = false;

        return answer;
    }
}