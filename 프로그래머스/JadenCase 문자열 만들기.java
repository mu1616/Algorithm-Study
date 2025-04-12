import java.util.*;
import java.util.stream.Collectors;

class Solution {

    private static Map<Character, Character> UPPER_TO_LOWER = new HashMap<>();
    private static Map<Character, Character> LOWER_TO_UPPER = new HashMap<>();

    static {
        char alphabet = 'a';
        for (int i = 0; i < 26; i++) {
            char target = (char) (alphabet + i);
            String targetStr = String.valueOf(target);
            UPPER_TO_LOWER.put(targetStr.toUpperCase().charAt(0), targetStr.toLowerCase().charAt(0));
            LOWER_TO_UPPER.put(targetStr.charAt(0), targetStr.toUpperCase().charAt(0));
        }
    }
    public String solution(String s) {
        if (s.equals(" ")) {
            return s;
        }
        String[] words = s.split(" ", -1);
        return Arrays.stream(words)
                .map(this::toJadenCase)
                .collect(Collectors.joining(" "));
    }

    private String toJadenCase(String str) {
        char[] characters = str.toCharArray();
        char[] updatedCharacters = new char[characters.length];
        for (int i = 0 ; i < characters.length; i++) {
            char c = characters[i];
            if (i == 0) {
                updatedCharacters[i] = LOWER_TO_UPPER.getOrDefault(c, c);
            } else {
                updatedCharacters[i] = UPPER_TO_LOWER.getOrDefault(c, c);
            }
        }
        return new String(updatedCharacters);
    }
}