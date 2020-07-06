import java.util.*;

class Solution {
   public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        char end = 0;

        for(int i = 0; i< words.length; i++) {
            if(i == 0) {
                end = words[i].charAt(words[i].length() - 1);
                set.add(words[i]);
                continue;
            }

            if(words[i].charAt(0) == end && !set.contains(words[i])) {
                end = words[i].charAt(words[i].length() - 1);
                set.add(words[i]);

            } else {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
        }

        return answer;
    }
}