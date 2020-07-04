public class Solution {
    public int solution(int n) {
        int ans = 0;

        while(true){
            if(n == 0){
                break;
            }

            if( n %2 == 0){
                n = n /2;
            } else {
                n = n - 1;
                ans++;
            }

        }

        return ans;
    }
}