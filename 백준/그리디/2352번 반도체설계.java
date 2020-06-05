import java.math.BigInteger;
import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int array[];
	int result;
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		array = new int[n];
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i< n; i++) {
			array[i] = scan.nextInt();
		}
		//recursion(0, 0, 0);
		//System.out.println(result);
		list.add(array[0]);
		for(int i=1; i< n; i++) {
			if(list.get(0) > array[i]) {
				list.set(0, array[i]);
			}
			else if(list.get(list.size()-1) < array[i]) {
				list.add(array[i]);
			}
			else {
				int k = Collections.binarySearch(list, array[i]);
				int idx = -(k+1);
				list.set(idx, array[i]);
			}
		}
		System.out.println(list.size());
		
	}
	
	

}