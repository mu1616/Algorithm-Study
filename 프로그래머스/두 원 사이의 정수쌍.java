class Solution {
    public long solution(int r1, int r2) {
        long r1Pow = (long) Math.pow(r1, 2);
        long r2Pow = (long) Math.pow(r2, 2);
        long answer = 0;
        for (int x = 0; x <= r2; x++) {
            double inner = x > r1 ? 0 : Math.sqrt(r1Pow - Math.pow(x, 2));
            double outer = Math.sqrt(r2Pow - Math.pow(x, 2));
            long cnt = (long) outer - (long) inner;
            if (inner % 1 == 0) {
                cnt++;
            }
            answer = answer + cnt;
        }
        answer = answer * 4;
        answer = answer - ((r2 - r1 + 1) * 4);
        return answer;
    }
}