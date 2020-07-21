import java.util.*;
import java.io.*;
class Main {
	static Scanner scan = new Scanner(System.in);
	int result;
	
	public static void main(String[] args){
		Main main = new Main();
		main.solution();
	}
	
	public void solution() {
		int n = scan.nextInt();
		int array[] = new int[1000000];
		
		for(int i = 0; i < n; i++)
			array[i] = scan.nextInt();
		
		int b = scan.nextInt();
		int c = scan.nextInt();
		long answer = n;
		
		for(int i = 0; i < n; i++) {
			int k = array[i] - b;
			if(k > 0) {
				if(k % c == 0) 
					answer += k / c;
				else
					answer += k / c + 1;
			}
		}
		
		System.out.println(answer);
	}
}