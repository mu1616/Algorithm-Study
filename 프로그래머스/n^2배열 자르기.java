class Solution {
    public int[] solution(int n, long left, long right) {
        int answerSize = (int) (right - left + 1);
        int[] answer = new int[answerSize];
        for (long i = left ; i <= right; i++) {
            long n1 = (i / n) + 1; 
            long n2 = (i + 1) % n == 0 ? n : (i + 1) % n; 
            if (n1 > n2) {
                answer[(int) (i - left)] = (int) n1;
            } else {
                answer[(int) (i - left)] = (int) n2;
            }
        }
        return answer;
    }
}