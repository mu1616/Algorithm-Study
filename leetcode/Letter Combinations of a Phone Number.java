class Solution {

    public static Map<Integer, List<Character>> PHONE = new HashMap<>();

    static {
        PHONE.put(1, List.of());
        PHONE.put(2, List.of('a', 'b', 'c'));
        PHONE.put(3, List.of('d', 'e', 'f'));
        PHONE.put(4, List.of('g', 'h', 'i'));
        PHONE.put(5, List.of('j', 'k', 'l'));
        PHONE.put(6, List.of('m', 'n', 'o'));
        PHONE.put(7, List.of('p', 'q', 'r', 's'));
        PHONE.put(8, List.of('t', 'u', 'v'));
        PHONE.put(9, List.of('w', 'x', 'y', 'z'));
    }

    public List<String> result = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.emptyList();
        }
        List<List<Character>> list = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            list.add(PHONE.get(Integer.valueOf(digits.substring(i, i + 1))));
        }
        dfs(list, 0, new Stack<>());
        return result;
    }
    
    public void dfs(List<List<Character>> list, int outerIndex, Stack<Character> stack) {
        if (outerIndex == list.size()) {
            result.add(stack.stream()
                    .map(c -> String.valueOf(c))
                    .collect(Collectors.joining()));
            return;
        }
        List<Character> outerList = list.get(outerIndex);
        for (Character c : outerList) {
            stack.push(c);
            dfs(list, outerIndex + 1, stack);
            stack.pop();
        }
    }
}