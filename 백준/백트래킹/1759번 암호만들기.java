import java.util.*;

class Main {

	TreeSet<String> set = new TreeSet<>();
	static Scanner scan = new Scanner(System.in);
	int l;
	public static void main(String[] args) {
		Main m = new Main();
		m.solution();
	}

	public void solution() {
		l = scan.nextInt();
		int c = scan.nextInt();
		char array[] = new char[c];
		for (int i = 0; i < c; i++) {
			array[i] = scan.next().charAt(0);
		}
		recursion(array, 0, l);		
		for(String t : set)
			System.out.println(t);
	}

	public void recursion(char array[], int start, int r) {
		if (r == 0 && contains(array,l)) {
			set.add(String.valueOf(array,0,l));
		} else {
			for (int i = start; i < array.length; i++) {

				if (start == 0) {
					swap(array, start, i);
					recursion(array, start + 1, r - 1);
					swap(array, start, i);
				} else {
					if (array[start - 1] <= array[i]) {
						swap(array, start, i);
						recursion(array, start + 1, r - 1);
						swap(array, start, i);
					}
				}
			}
		}
	}

	public void swap(char array[], int i, int j) {
		char tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public boolean contains(char array[], int length) {
		int Mcount = 0;
		int Jcount = 0;
		for(int i=0; i< length; i++) {
			if(array[i] == 'a' || array[i] == 'e' || array[i] == 'i' || 
					array[i] == 'o' || array[i] == 'u') {
				Mcount++;
			} else {
				Jcount++;
			}
		}
		if(Mcount >=1 && Jcount >=2) {
			return true;
		} else {
			return false;
		}
	}

}