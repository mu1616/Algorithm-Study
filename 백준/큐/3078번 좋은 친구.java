import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
    
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}
	
    public void solution() {
    	int n = scan.nextInt();
    	int k = scan.nextInt();
    	String arr[] = new String[n];
    	for(int i = 0; i < n; i++) {
    		arr[i] = scan.next();
    	}
    	
    	Queue<Integer> queue[] = new LinkedList[21];
    	for(int i = 0; i < 21; i++) queue[i] = new LinkedList<>();
    	
    	long cnt = 0;
    	
    	for(int i = 0; i < n; i++) {
    		int len = arr[i].length();
    		
    		while(!queue[len].isEmpty() && i - queue[len].peek() > k) {
    			queue[len].poll();
    		}
    		
    		cnt += queue[len].size();
    		queue[len].offer(i);
    	}

    	System.out.println(cnt);
    }
}