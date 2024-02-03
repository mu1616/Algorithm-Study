import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        char[] currentCharArr = s.toCharArray();
        List<Character> alphabets = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            alphabets.add(c);
        }
        for (char c : skip.toCharArray()) {
            alphabets.remove(Character.valueOf(c));
        }
        StringBuilder sb = new StringBuilder();
        for (char c : currentCharArr) {
            int currentIndex = alphabets.indexOf(c);
            int nextIndex = (currentIndex + index) % alphabets.size();
            sb.append(alphabets.get(nextIndex));
        }
        return sb.toString();
    }
}