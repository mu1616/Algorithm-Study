import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	String array[];
	HashSet<String> set = new HashSet<>();
	ArrayList<String> list;
	HashMap<Character, Integer> map = new HashMap<>();
	long answer;
	char[][] cArray = new char[1][1];
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}
	
	public void solution() {
		int n = scan.nextInt();
		array = new String[n];
		
		for(int i=0; i< n; i++) {
			array[i] = scan.next();
			for(int j=0; j< array[i].length(); j++) {
				set.add(array[i].substring(j, j+1));
			}
		}
		list = new ArrayList<>(set);
		
		for(int i=0; i< list.size(); i++) {
			map.put(list.get(i).charAt(0), i);
		}
		
		int numList[] = new int[list.size()];
		int max = 9;
		for(int i=0; i< numList.length; i++) 
			numList[i] = max--;

		permu(numList, 0, numList.length);
		System.out.println(answer);

	}
	
	public void permu(int numList[], int start, int r) {
		if(r==0) {			
			long sum = 0;
			for(int i=0; i< array.length; i++) {
				long exp = 1;
				for(int j = array[i].length()-1; j>=0; j--) {				
					int idx = map.get(array[i].charAt(j));
					sum = sum + numList[idx]*exp;
					exp *= 10;
				}
				if(answer < sum) answer = sum;
			}
		}else {
			for(int i = start; i < numList.length; i++) {
				swap(numList, start, i);
				permu(numList, start+1, r-1);
				swap(numList, start, i);
			}
		}
	}
	
	public void swap(int array[], int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	
}
