class Solution {
    
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		String binaryMap1[] = new String[n];
		String binaryMap2[] = new String[n];

		for (int i = 0; i < n; i++) {
			binaryMap1[i] = Integer.toBinaryString(arr1[i]);
			int cnt = n - binaryMap1[i].length();

			for (int j = 0; j < cnt; j++) {
				binaryMap1[i] = "0" + binaryMap1[i];
			}

			binaryMap2[i] = Integer.toBinaryString(arr2[i]);
			cnt = n - binaryMap2[i].length();

			for (int j = 0; j < cnt; j++) {
				binaryMap2[i] = "0" + binaryMap2[i];
			}
		}

		for (int i = 0; i < n; i++) {
			answer[i] = "";
			String str1 = binaryMap1[i];
			String str2 = binaryMap2[i];
			for (int j = 0; j < n; j++) {
				if(str1.charAt(j) == '1' || str2.charAt(j) == '1') {
					answer[i] += "#";
				} else {
					answer[i] += " ";
				}
			}
		}
		return answer;
	}


}