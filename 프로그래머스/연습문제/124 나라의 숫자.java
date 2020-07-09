import java.util.*;
import java.math.*;
class Solution {
    public String solution(int k) {
        int n[] = {0, 1, 2, 4};
        String answer = "";

        while(true) {
            int a = (k - 1) / 3;
            answer = String.valueOf(n[k - 3*a]) + answer;
            k = a;

            if(k == 0) {
                break;
            }
        }

        answer = String.valueOf(answer);
        return answer;
    }
}