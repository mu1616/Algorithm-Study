import java.math.BigDecimal;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int length = p.length();
        BigDecimal numP = new BigDecimal(p);
        for (int i = 0; i < t.length(); i++) {
            int beginIndexInclusive = i;
            int endIndexExclusive = i + length;
            if (endIndexExclusive > t.length()) {
                break;
            }
            BigDecimal numT = new BigDecimal(t.substring(beginIndexInclusive, endIndexExclusive));
            if (numT.compareTo(numP) <= 0) {
                answer++;
            }
        }
        return answer;
    }
}
