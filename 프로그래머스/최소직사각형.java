import java.util.*;

class Solution {
    
    public int solution(int[][] sizes) {
        int w = 0;
        int h = 0;
        for (int i = 0; i < sizes.length; i++) {
            if ((sizes[i][0] <= w && sizes[i][1] <= h) || (sizes[i][0] <= h && sizes[i][1] <= w)) {
                continue;
            }
            int candidateW1 = Math.max(w, sizes[i][0]);
            int candidateH1 = Math.max(h, sizes[i][1]);
            int candidateArea1 = candidateW1 * candidateH1;

            int candidateW2 = Math.max(w, sizes[i][1]);
            int candidateH2 = Math.max(h, sizes[i][0]);
            int candidateArea2 = candidateW2 * candidateH2;
            
            if (candidateArea1 <= candidateArea2) {
                w = candidateW1;
                h = candidateH1;
            } else {
                w = candidateW2;
                h = candidateH2;
            }
        }
        return w * h;
    }
}