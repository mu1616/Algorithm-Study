class Solution {

    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (sb.length() > 0) {
                    stack.push(sb.toString());
                }
                sb.delete(0, sb.length());
                continue;
            }
            sb.append(s.charAt(i));
        }
        if (sb.length() > 0) {
            stack.push(sb.toString());
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            if (!result.isEmpty()) {
                result.append(" ");
            }
            result.append(stack.pop());
        }
        return result.toString();
    }
}