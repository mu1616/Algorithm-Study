import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Main main = new Main();
		int prices[] = {1,2,3,2,3};
		main.solution(prices);
	}
	
	public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Node> st = new Stack<>();
        
        for(int i=0; i< prices.length; i++) {
        	answer[i] = prices.length - 1 - i;
        	
        	while(true) {
        		if(st.isEmpty()) {
        			st.push(new Node(i, prices[i]));
        			break;
        		}
        		
        		if(st.peek().price <= prices[i]) {
        			st.push(new Node(i, prices[i]));
        			break;
        		}
        		
        		Node top = st.pop();
        		answer[top.idx] = i - top.idx;
        	}
        }
        
       
        return answer;
    }
	
	class Node {
		int idx;
		int price;
		Node(int idx, int price){
			this.idx = idx;
			this.price = price;
		}
	}
}
