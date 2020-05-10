package algorithm;

import java.util.*;

class Main {

	public static void main(String[] args) {
		Main m = new Main();
		String exp = "100/10+10/10*10";
		m.calExpression(exp);
	}
	
	//정상적인 계산일 때 연산자 우선순위는 '*' > '-' > '+' 순서로 해야함!
	//+가 - 보다 앞서게 되면 50+1-60+2 --> (50+1)-(60+2) 가 되기때문
	//반면 -가 +보다 앞서게 되면 50+(1-60)+2 인데 이경우에는 문제가 되지않음
	//같은 원리로 '/' > '*'
	//그 외 연산자 우선순위가 바뀌는 문제라면 order 배열에 알맞게 넣어주면됨
	public void calExpression(String exp) {
		String [] order = {"/","*","-","+"};   //연산자 우선순위
		List<String> list = new ArrayList<>();
		int n = 0;  //숫자가 시작하는 인덱스번호
		for(int i=0; i< exp.length(); i++) {
			if(exp.charAt(i) == '*' || exp.charAt(i) == '+' || exp.charAt(i) == '-' ||
					exp.charAt(i) == '/') {
				list.add(exp.substring(n,i));  //수식 앞에 숫자 list에 추가
				list.add(exp.substring(i,i+1));  //숫자 list에 추가
				n = i+1;
			}
		}
		list.add(exp.substring(n,exp.length())); //마지막 숫자 list에 추가
		
		//우선순위 연산자 부터 계산 
		//list에 저장된 것이 i-1=300, i='*', i+1=500  이라면 
		//i-1 = 300*500 , i와 i+1은삭제
		for(int i=0; i< order.length; i++) {
			for(int j=0; j< list.size(); j++) {
				if(list.get(j).equals(order[i])) {   
					int result = cal(Integer.parseInt(list.get(j-1)), Integer.parseInt(list.get(j+1)), list.get(j));
					list.set(j-1, Integer.toString(result));
					list.remove(j);
					list.remove(j);  // 앞에서 remove(j)하면 j+1인덱스가 j인덱스로 땡겨지므로 또다시 remove(j)를함
					j = j-1;   // result가 담긴 인덱스의 다음 인덱스부터 진행하도록 j를 조정
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