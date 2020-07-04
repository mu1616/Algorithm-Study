import java.util.*;
class Solution {
    static Scanner scan = new Scanner(System.in);
    Stack<Integer> stack = new Stack<>();
    int answer;

    public int solution(int[] nums) {
        combi(nums, 0, 3);

        return answer;
    }

    public void combi(int [] nums, int start, int r) {
        if(r == 0) {
            int sum = 0;
            for(int i : stack)
                sum += i;

            if(isPrime(sum)) {
                answer++;
            }

        } else {
            for(int i = start; i < nums.length; i++) {
                stack.push(nums[i]);
                combi(nums, i + 1, r - 1);
                stack.pop();
            }
        }
    }

    public boolean isPrime(int n) {
        if(n == 1) {
            return false;
        }

        for(int i = 2; i < n; i++) {
            if(n % i == 0)
                return false;
        }

        return true;
    }

}