import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();

	}

	public void solution() {
		int k = scan.nextInt();
		int array[] = new int[k + 1];
		for (int i = 1; i < k + 1; i++) {
			if(i >= 365)
				array[i] = array[i-365] + 1;
			else if(i >= 91)
				array[i] = array[i-91] + 1;
			else if(i >= 52)
				array[i] = array[i-52] + 1;
			else if(i >=28)
				array[i] = array[i-28] + 1;
			else if(i >= 13)
				array[i] = array[i-13] + 1;
			else if(i >= 7)
				array[i] = array[i-7] + 1;
			else if(i >= 4)
				array[i] = array[i-4] + 1;
			else if(i >= 1)
				array[i] = array[i-1] + 1;
		}
		System.out.println(array[k]);

	}

}

