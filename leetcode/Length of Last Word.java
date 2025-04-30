class Solution {
    
    public int lengthOfLastWord(String s) {
        boolean isWord = false;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!isWord) {
                if (s.charAt(i) == ' ') {
                    continue;
                } else {
                    isWord = true;
                    count++;
                    continue;
                }
            }
            if (isWord) {
                if (s.charAt(i) == ' ') {
                    break;
                } else {
                    count++;
                }
            }
        }
        return count;
    }
}