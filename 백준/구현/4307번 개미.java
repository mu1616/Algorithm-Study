import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		int n = scan.nextInt();
		for(int i = 0; i < n; i++)
			main.solution();
	}

    public void solution() {
    	int l = scan.nextInt();
    	int n = scan.nextInt();
    	int ants[] = new int[n];
    	for(int i = 0; i < n; i++) ants[i] = scan.nextInt();  	
    	Arrays.sort(ants);
    	
    	int answerMin = Integer.MIN_VALUE;
    	int answerMax = Integer.MIN_VALUE;
    	for(int i = 0; i < n; i++) {
    		int min = Math.min(ants[i] - 0, l - ants[i]);
    		int max = Math.max(ants[i] - 0, l - ants[i]);
    		if(answerMin < min) answerMin = min;
    		if(answerMax < max) answerMax = max;
    	}
    	System.out.println(answerMin+" "+answerMax);

    }
}