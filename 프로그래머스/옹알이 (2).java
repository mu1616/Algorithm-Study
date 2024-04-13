import java.util.*;

class Solution {
    List<String> SPEAKABLE_WORDS = List.of("aya", "ye", "woo", "ma");
    
    public int solution(String[] babbling) {
        int answer = 0;
        for (String str : babbling) {
            if (canSpeak(str, 0, "")) {
                answer++;
            }
        }
        return answer;
    }

    private boolean canSpeak(String word, int startIndex, String beforeSpeakWord) {
        if (word.length() == startIndex) {
            return true;
        }
        for (String speakWord : SPEAKABLE_WORDS) {
            if (word.substring(startIndex).startsWith(speakWord) && !speakWord.equals(beforeSpeakWord)) {
                return canSpeak(word, startIndex + speakWord.length(), speakWord);
            }
        }
        return false;
    }
}