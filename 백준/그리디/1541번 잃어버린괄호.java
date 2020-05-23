import java.util.*;
class Main {
	
	public static void main(String[] args) {
		Main m = new Main();
		String exp = new Scanner(System.in).next();
		m.calExpression(exp);
	}
	
	public void calExpression(String exp) {
		String [] order = {"/","*","+","-"};   
		List<String> list = new ArrayList<>();
		int n = 0;  
		for(int i=0; i< exp.length(); i++) {
			if(exp.charAt(i) == '*' || exp.charAt(i) == '+' || exp.charAt(i) == '-' ||
					exp.charAt(i) == '/') {
				list.add(exp.substring(n,i));  
				list.add(exp.substring(i,i+1)); 
				n = i+1;
			}
		}
		list.add(exp.substring(n,exp.length())); 
		
		for(int i=0; i< order.length; i++) {
			for(int j=0; j< list.size(); j++) {
				if(list.get(j).equals(order[i])) {   
					int result = cal(Integer.parseInt(list.get(j-1)), Integer.parseInt(list.get(j+1)), list.get(j));
					list.set(j-1, Integer.toString(result));
					list.remove(j);
					list.remove(j);   
					j = j-1;   
				}
			}
		}

		System.out.println(list.get(0));
	}
	
	public int cal(int a, int b, String exp) {
		if(exp.equals("*"))
			return a*b;
		if(exp.equals("+"))
			return a+b;
		if(exp.equals("-"))
			return a-b;
		if(exp.equals("/"))
			return a/b;
		return -1;
	}
	

}