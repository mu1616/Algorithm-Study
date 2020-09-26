import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

    public void solution() {
    	int n = scan.nextInt();
    	long arr[] = new long[n];
    	for(int i = 0; i < n; i++) arr[i] = scan.nextInt();
    	Stack<Long> stack = new Stack<>();
    	Arrays.sort(arr);
    	long a = 1000000000;
    	long b = -1000000000;

    	int left = 0;
    	int right = n - 1;
    	stack.push(arr[left]);
    	stack.push(arr[right]);
    	long min = Long.MAX_VALUE;
    	while(left < right) {
    		if(Math.abs(arr[left] + arr[right]) < min) {
    			stack.pop();
    			stack.pop();
    			stack.push(arr[left]);
    			stack.push(arr[right]);
    			min = Math.abs(arr[left] + arr[right]);
    		}
    		
    		if(arr[left] * arr[right] < 0) {
    			if(Math.abs(arr[left]) < Math.abs(arr[right])) {
    				right -= 1;
    			} else if(Math.abs(arr[left]) > Math.abs(arr[right])) {
    				left += 1;
    			} else {
    				left += 1;
    				right -= 1;
    			}

    		} else if(arr[left] >= 0 && arr[right] >= 0) {
    			right -= 1;
    		} else if(arr[left] <= 0 && arr[right] <= 0) {
    			left += 1;
    		}
    	}
    	
    	long rightNumber = stack.pop();
    	long leftNumber = stack.pop();
    	System.out.println(leftNumber+" "+rightNumber);
    }
}