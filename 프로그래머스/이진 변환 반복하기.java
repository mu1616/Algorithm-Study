import java.util.*;

class Solution {
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        String convertedStr = s;
        while (!convertedStr.equals("1")) {
            answer[1] = answer[1] + getZeroCount(convertedStr);
            convertedStr = convert(convertedStr);
            answer[0] = answer[0] + 1;
        }
        return answer;
    }

    public String convert(String str) {
        String tempStr = str.replaceAll("0", "");
        return Integer.toBinaryString(tempStr.length());
    }

    public int getZeroCount(String str) {
        int result = 0;
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c == '0') {
                result++;
            }
        }
        return result;
    }
}