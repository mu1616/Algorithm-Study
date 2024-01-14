import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answers = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                char c = keymap[i].charAt(j);
                if (map.containsKey(c)) {
                    map.put(c, Math.min(map.get(c), j + 1));
                } else {
                    map.put(c, j + 1);
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int answer = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                char c = targets[i].charAt(j);
                if (map.containsKey(c)) {
                    answer = answer + map.get(c);
                } else {
                    answer = -1;
                    break;
                }
            }
            answers[i] = answer;
        }

        return answers;
    }
}