package algorithm;

import java.util.*;

class Main {
	String[] order;
	String expression;
	ArrayList<Integer> result = new ArrayList<>();
	public static void main(String[] args) {
		Main m = new Main();
		String exp = "50*6-3*2";
		System.out.println(m.solution(exp));
	}

	public int solution(String exp) {
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < exp.length(); i++) {
			if (exp.charAt(i) == '*' || exp.charAt(i) == '+' || exp.charAt(i) == '-') {
				if (!list.contains(Character.toString(exp.charAt(i))))
					list.add(Character.toString(exp.charAt(i)));
			}
		}
		order = list.toArray(new String[list.size()]);
		expression = exp;
		permutation(order, 0, order.length);
		Collections.sort(result);
		return result.get(result.size()-1);
	}

	public String calExpression(String exp, String[] order) {
		List<String> list = new ArrayList<>();
		int n = 0; 
		for (int i = 0; i < exp.length(); i++) {
			if (exp.charAt(i) == '*' || exp.charAt(i) == '+' || exp.charAt(i) == '-' || exp.charAt(i) == '/') {
				list.add(exp.substring(n, i)); 
				list.add(exp.substring(i, i + 1)); 
				n = i + 1;
			}
		}
		list.add(exp.substring(n, exp.length())); 

		for (int i = 0; i < order.length; i++) {
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).equals(order[i])) {
					int result = cal(Integer.parseInt(list.get(j - 1)), Integer.parseInt(list.get(j + 1)), list.get(j));
					list.set(j - 1, Integer.toString(result));
					list.remove(j);
					list.remove(j);
					j = j - 1; 
				}
			}
		}

		return list.get(0);
	}

	public int cal(int a, int b, String exp) {
		if (exp.equals("*"))
			return a * b;
		if (exp.equals("+"))
			return a + b;
		if (exp.equals("-"))
			return a - b;
		if (exp.equals("/"))
			return a / b;
		return -1;
	}

	public void permutation(String[] array, int start, int r) {
		if (r == 0) {
			result.add(Math.abs(Integer.parseInt(calExpression(expression, array))));
		} else {
			for (int i = start; i < array.length; i++) {
				swap(array, start, i); 
				permutation(array, start + 1, r - 1);
				swap(array, start, i); 
			}
		}
	}

	public void swap(String[] array, int i, int j) {
		String temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}