class Solution {

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = gcd(arrayA);
        int gcdB = gcd(arrayB);

        boolean isPossibleAnswerByGcdA = isPossibleAnswer(gcdA, arrayB);
        boolean isPossibleAnswerByGcdB = isPossibleAnswer(gcdB, arrayA);
        
        if (isPossibleAnswerByGcdA && isPossibleAnswerByGcdB) {
            return Math.max(gcdA, gcdB);
        }
        if (isPossibleAnswerByGcdA) {
            return gcdA;
        }
        if (isPossibleAnswerByGcdB) {
            return gcdB;
        }
        return answer;
    }

    public int gcd(int[] array) {
        int gcd = array[0];
        for (int n : array) {
            gcd = gcd(n, gcd);
        }
        return gcd;
    }
    public int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    public boolean isPossibleAnswer(int candidate, int[] array) {
        for (int n : array) {
            if (n % candidate == 0) {
                return false;
            }
        }
        return true;
    }
}