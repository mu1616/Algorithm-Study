class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.merge(c, 1, (existValue, newValue) -> existValue + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            Integer value = map.get(c);
            if (value == null) {
                return false;
            }
            if (value == 1) {
                map.remove(c);
            } else {
                map.put(c, value - 1);
            }
        }
        return true;
    }
}