import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);

            if(stack.isEmpty()) {
                stack.push(a);
                continue;
            }

            if(stack.peek() != a) {
                stack.push(a);

            } else {
                stack.pop();
            }
        }

        if(stack.isEmpty())
            return 1;
        else
            return 0;
    }
}

