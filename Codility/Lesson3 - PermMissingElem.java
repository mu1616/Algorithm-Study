class Solution {
    public int solution(int[] arr) {
    	boolean visited[] = new boolean[arr.length + 2];
    	for (int num : arr)
    		visited[num] = true;
    	
    	for (int i = 1; i < visited.length; i++) {
    		if (!visited[i])
    			return i;
    	}
    	
    	return -1;
    }
}