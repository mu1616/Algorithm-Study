import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
    
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}
	
    public void solution() {
    	int n = scan.nextInt();
    	String str = scan.next();
    	HashMap<Character, Double> map = new HashMap<>();
    	for(int i = 0; i < n; i++) {
    		map.put((char)(i + 65), scan.nextDouble());
    	}
    	
    	Stack<Double> stack = new Stack<>();
    	for(int i = 0; i < str.length(); i++) {
    		char a = str.charAt(i);
    		
    		if(a >= 65 && a <= 90) {
    			stack.push(map.get(a));
    			
    		} else {
    			double n1 = stack.pop();
    			double n2 = stack.pop();
    			stack.push(calc(n2, n1, a));
    		}
    	}
    	
    	System.out.printf("%.02f", stack.pop());
    	
    }
    
    public double calc(double a, double b, char c) {
    	switch(c) {
    		case '*' : return a * b;
    		case '+' : return a + b;
    		case '-' : return a - b;
    		case '/' : return a / b;
    	} 	
    	
    	return -1;
    }
}