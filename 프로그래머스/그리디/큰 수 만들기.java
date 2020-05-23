class Solution {
   public String solution(String number, int k) {
		StringBuffer n = new StringBuffer(number);
		int min = n.charAt(0);
		for (int i = 1; i < n.length(); i++) {
			int a = n.charAt(i);
			if (n.charAt(i-1) < a) {
				for (int j = i - 1; j >= 0; j--) {
					int b = n.charAt(j);
					if (a > b) {
						n.deleteCharAt(j);
						i--;
						k--;
					}
					if (k == 0)
						break;
				}
			}

			if (k == 0)
				break;
		}
		String answer = n.substring(0, n.length() - k);
		return answer;
	}

}