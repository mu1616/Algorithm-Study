package algorithm;

import java.math.BigInteger;
import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	boolean visited[];
	int array[];
	int output[];
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		array = new int[n];
		visited = new boolean[n];
		output = new int[n];
		
		for(int i = 0; i < n; i++) array[i] = i + 1;
		
		permu(0);
	}
	
	public void permu(int depth) {
		if(depth == array.length) {
			for(int i = 0; i < output.length; i++) {
				System.out.print(output[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < array.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = array[i];
				permu(depth + 1);
				visited[i] = false;
			}
		}
	}
	

}