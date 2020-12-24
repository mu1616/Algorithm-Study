package algorithm;

import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int max = 0;
	int array[];
	boolean visited[];
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		array = new int[n];
		visited = new boolean[n];
		for(int i = 0; i < n; i++) array[i] = scan.nextInt();
		
		recursion(array, 0);
		System.out.println(max);
	}
	
	public void recursion(int array[], int energy) {
		boolean isFinish = true;
		for(int i = 1; i < array.length - 1; i++) {
			if(!visited[i]) {
				isFinish = false;
				int leftValue = findLeft(array, i);
				int rightValue = findRight(array, i);
				visited[i] = true;
				recursion(array, energy + (leftValue * rightValue));
				visited[i] = false;
			}
		}
		
		if (isFinish) {
			max = Math.max(max, energy);
		}
	}
	
	public int findLeft(int array[], int index) {
		int leftValue = -1;
		for(int i = index - 1; i >= 0; i--) {
			if(!visited[i]) {
				leftValue = array[i];
				break;
			}
		}
		return leftValue;
	}
	
	public int findRight(int array[], int index) {
		int rightValue = -1;
		for(int i = index + 1; i < array.length; i++) {
			if(!visited[i]) {
				rightValue = array[i];
				break;
			}
		}
		return rightValue;
	}

}