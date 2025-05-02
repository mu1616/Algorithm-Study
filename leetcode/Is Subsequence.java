class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int sIndex = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(sIndex)) {
                sIndex++;
            }
            if (sIndex == s.length()) {
                return true;
            }
        }
        return false;
    }
}