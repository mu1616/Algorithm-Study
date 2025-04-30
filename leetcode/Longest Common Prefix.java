class Solution {

    public String longestCommonPrefix(String[] strs) {
        Map<String, Integer> prefixCountMap = new HashMap<>();
        for (String str : strs) {
            for (int i = 1; i <= str.length(); i++) {
                prefixCountMap.merge(str.substring(0, i), 1, (existValue, newValue) -> existValue + 1);
            }
        }
        return prefixCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() == strs.length)
                .max(Comparator.comparingInt((Map.Entry<String, Integer> entry) -> entry.getKey().length()))
                .map(Map.Entry::getKey)
                .orElse("");
    }
}