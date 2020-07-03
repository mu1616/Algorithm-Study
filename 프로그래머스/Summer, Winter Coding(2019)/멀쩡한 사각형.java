class Solution {
    public long solution(int w, int h) {
        long answer = 0;
   
        for(int i=1; i<= w; i++) {
        	double a = lineFunc(i, w, h);
        	answer += (long)(h - Math.abs(a));
        	//System.out.println((long)(h - Math.abs(a)));
        }
        
        answer *= 2;
        
        return answer;
    }
    
    public double lineFunc(int x, int w, int h) {
    	return -x * ((double)h / w);
    }
}