class Solution {
    public long solution(int n) {
        long answer = 0;
        long fib[] = new long[n+1];
        fib[1] = 4;
        if(n>=2)
        fib[2] = 6;
        for(int i=3; i< n+1; i++) {
        	fib[i] = fib[i-1] + fib[i-2];
        }
        answer = fib[n];
        System.out.println(answer);
        return answer;
    }
}