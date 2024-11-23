import java.util.*;

class Solution {
    
    private static final Map<Character, Character> PAIR_MAP = Map.of(
            ']', '[',
            '}', '{',
            ')', '('
    );

    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            String rotateStr = s.substring(i) + s.substring(0, i);
            if (isRightString(rotateStr)) {
                answer++;
            }
        }
        return answer;
    }

    public boolean isRightString(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (PAIR_MAP.containsKey(c) && PAIR_MAP.get(c) == stack.peek()) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        return stack.isEmpty();
    }
}