class Solution {
    
	boolean visited[];
	int min = 999999999;

	public int solution(String begin, String target, String[] words) {
		int answer = 0;
		visited = new boolean[words.length];
		recursion(begin, target, words, 0);
		if(min == 999999999)
			answer = 0;
		else 
			answer = min;
		System.out.println(answer);
		return answer;
    }
	
	public void recursion(String str, String target, String words[], int depth) {
		if(str.equals(target)) {
			if(min > depth) 
				min = depth;
			return;
		}
		for(int i=0; i< words.length; i++) {
			String word = words[i];
			int cnt =0;		
			for(int j=0; j< word.length(); j++) {
				if(str.charAt(j) == word.charAt(j)) {
					cnt++;
				}
			}
			if (cnt == str.length()-1 && visited[i] == false) {	 //1글자만 틀리다면
				visited[i] = true;
				recursion(word, target, words, depth+1);
				visited[i] = false;
			}
		}
	}
}