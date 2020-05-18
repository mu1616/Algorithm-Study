import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
		
	}

	public void solution() {
		int array[] = {31, -41, 59, 26, -53, 58, 97, -93, -23, 84};
		int tmp[] = new int[11];
		for(int i=0; i< array.length; i++) {
			tmp[i+1] = tmp[i] + array[i];
		}
		int b= maxIndex(tmp) -1;
		int a = minIndex(tmp);
		System.out.println(a+","+b);
	}
	
	public int maxIndex(int [] array) {
		int maxIndex = 0;
		for(int i=1; i< array.length; i++) {
			if(array[maxIndex] < array[i]) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	public int minIndex(int []array) {
		int minIndex = 0;
		for(int i=1; i< array.length; i++) {
			if(array[minIndex] > array[i]) {
				minIndex = i;
			}
		}
		return minIndex;
	}

}
