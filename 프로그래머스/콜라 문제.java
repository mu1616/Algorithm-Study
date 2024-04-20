class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while (true) {
            int coke = (n / a) * b;
            if (coke == 0) {
                break;
            }
            answer = answer + coke;
            n = coke + (n % a);
        }
        return answer;
    }
}