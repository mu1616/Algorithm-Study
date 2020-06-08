class Solution {
   public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		int size = brown + yellow;
		for(int i=1; i<= size; i++) {   //i = 세로길이
			if(size % i !=0) continue;
			int row = i;
			int col = size/row;
			if(row > col) break;
			if(brown == col*2 + (row-2)*2) {
				answer[0] = col;
				answer[1] = row;
			}
		}
		return answer;
	}
}