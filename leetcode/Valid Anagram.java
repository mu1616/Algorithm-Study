class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sCharacterToCount = new HashMap<>();
        Map<Character, Integer> tCharacterToCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character sChar = s.charAt(i);
            Character tChar = t.charAt(i);
            sCharacterToCount.merge(sChar, 1, (existValue, newValue) -> existValue + 1);
            tCharacterToCount.merge(tChar, 1, (existValue, newValue) -> existValue + 1);
        }
        
        return sCharacterToCount.equals(tCharacterToCount);
    }
}