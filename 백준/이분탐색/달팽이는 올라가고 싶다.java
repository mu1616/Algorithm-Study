import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
        int a = scan.nextInt();
        int b = scan.nextInt();
        int v = scan.nextInt();
        
        int left = 1;
        int right = v;
        int answer = 0;
        
        while(left <= right) {
        	int mid = (left + right) / 2;   	
        	int height = a*mid - b*(mid - 1);
        	
        	if(height >= v) {
        		right = mid - 1;
        		answer = mid;
        	} else {
        		left = mid + 1;
        	}
        }
        
        System.out.print(answer);
    }

	

}
