import java.util.*;

class Solution {
    public int solution(int n) {
        if (n == 0) return 0;
		int max = 0;
		int length = 0;
		boolean canCount = false;
		
		StringBuffer sb = new StringBuffer("");
		while (n >= 1) {
			if (n % 2 == 1) {
				sb.insert(0, "1");
				if (canCount) {
					max = Math.max(max, length);
					length = 0;
				}
				canCount = true;

			} else {
				sb.insert(0, "0");
				if(canCount) length++;
			}
			
			n = n / 2;

		}
		return max;
    }
}