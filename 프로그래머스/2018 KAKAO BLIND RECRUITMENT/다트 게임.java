class Solution {
	public int solution(String dartResult) {
		int answer = 0;
		String number = "1234567890a";
		int score[] = new int[3];		
		int start = 0;
		int i = 1;
		int cnt = 0;
        dartResult = dartResult.replace("10", "a");
        
		while (i <= dartResult.length()) {
			
			if (i == dartResult.length() || number.contains(dartResult.substring(i, i + 1))) {				
				String str = dartResult.substring(start, i);
				int n;
				if(str.substring(0, 1).equals("a")) 
					n = 10;
				else 
					n = Integer.parseInt(str.substring(0, 1));
				String sdt = str.substring(1, 2);
				
				if (sdt.equals("S")) {
					score[cnt] = (int) Math.pow(n, 1);

				} else if (sdt.equals("D")) {
					score[cnt] = (int) Math.pow(n, 2);

				} else if (sdt.equals("T")) {
					score[cnt] = (int) Math.pow(n, 3);
				}
				
				if(str.length() == 3) {
					String option = str.substring(2, 3);
					if(option.equals("#")) {
						score[cnt] = score[cnt] * (-1);
						
					} else if(option.equals("*")) {
						score[cnt] = score[cnt] * 2;
						if(cnt -1 >=0) 
							score[cnt - 1] = score[cnt - 1] * 2;
					}
				}
				cnt++;
				start = i;
			}
			i++;
		}
		
		//System.out.println(score[0] + score[1] + score[2]);
		answer = score[0] + score[1] + score[2];
		return answer;
	}
}