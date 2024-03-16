class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int cnt = 0;
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    if (j * j == i) {
                        cnt = cnt + 1;
                    } else {
                        cnt = cnt + 2;
                    }
                }
            }
            if (cnt > limit) {
                answer = answer + power;
            } else {
                answer = answer + cnt;
            }
        }
        return answer;
    }
}