package algorithm;

import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		Main main = new Main();
		int i = 0;
		while(true) {
			i++;
			int l = scan.nextInt();
			int p = scan.nextInt();
			int v = scan.nextInt();
			if (l == 0 && p == 0 && v == 0) {
				return;
			}
			int answer = main.solution(l, p, v);
			System.out.println("Case "+i+": "+answer);
		}
		
	}

	public int solution(int l, int p, int v) {
		int rest = (v % p > l) ? l : (v % p);
		return l * (v / p) + rest;
	}
}