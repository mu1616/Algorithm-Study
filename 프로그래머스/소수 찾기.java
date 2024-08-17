import java.util.*;

class Solution {
    List<Integer> primeNumbers = new ArrayList<>();
    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrimeNumber(i)) {
                answer++;
                primeNumbers.add(i);
            }
        }
        return answer;
    }

    public boolean isPrimeNumber(int num) {
        for (int primeNumber : primeNumbers) {
            int sqrtNum = (int) Math.sqrt(num);
            if (primeNumber > sqrtNum) {
                break;
            }
            if (num % primeNumber == 0) {
                return false;
            }
        }
        return true;
    }
}