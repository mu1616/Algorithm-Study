class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> openToCloseMap = Map.of(
                '(', ')',
                '{', '}', 
                '[', ']'
        );
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (openToCloseMap.containsKey(c)) {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (openToCloseMap.get(stack.pop()) != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}