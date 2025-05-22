class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Map<Character, Integer> characterCountMap = new HashMap<>();
            for (char c : str.toCharArray()) {
                characterCountMap.merge(c, 1, (existValue, newValue) -> existValue + 1);
            }

            map.putIfAbsent(characterCountMap, new ArrayList<>());
            map.get(characterCountMap).add(str);
        }

        return new ArrayList<>(map.values());
    }
}