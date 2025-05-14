class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> sReplaceMap = new HashMap<>();
        Map<Character, Character> tReplaceMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            Character sReplaceChar = sReplaceMap.get(sChar);
            Character tReplaceChar = tReplaceMap.get(tChar);

            System.out.println(sReplaceChar + " " + tReplaceChar);
            if (sReplaceChar == null && tReplaceChar == null) {
                sReplaceMap.put(sChar, tChar);
                tReplaceMap.put(tChar, sChar);
                continue;
            }

            if (sReplaceChar == null || tReplaceChar == null || !sReplaceChar.equals(tChar)) {
                return false;
            }
        }
        return true;
    }
}