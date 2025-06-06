class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operators = Set.of("+", "-", "*", "/");
        for (String token : tokens) {
            if (!operators.contains(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }
            int n1 = stack.pop();
            int n2 = stack.pop();
            if (token.equals("+")) {
                stack.push(n2 + n1);
                continue;
            }
            if (token.equals("-")) {
                stack.push(n2 - n1);
                continue;
            }
            if (token.equals("*")) {
                stack.push(n2 * n1);
                continue;
            }
            if (token.equals("/")) {
                stack.push(n2 / n1);
            }
        }
        return stack.pop();
    }
}