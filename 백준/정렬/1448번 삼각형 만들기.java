import java.util.*;
import java.io.*;
class Main {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Main main = new Main();
		main.solution();
	}
	
	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int array[] = new int[n];

		for(int i = 0; i < n; i++)
			array[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(array);
		
		int answer = -1;
		
		for(int i = 2; i < n; i++) {
			if(array[i - 1] + array[i - 2] > array[i]) 
				answer = array[i] + array[i - 1] + array[i - 2];
		}	
		
		System.out.println(answer);
	}
}