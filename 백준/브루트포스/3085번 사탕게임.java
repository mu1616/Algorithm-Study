import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		m.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		char candy[][] = new char[n][n];
		for (int i = 0; i < n; i++) {
			String str = scan.next();
			for (int j = 0; j < n; j++) {
				candy[i][j] = str.charAt(j);
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				swap(candy, i, j, i, j+1);
				int k = count(candy);
				swap(candy, i, j, i, j+1);
				list.add(k);
				swap(candy, j, i, j+1, i);
				k = count(candy);
				swap(candy, j, i, j+1, i);
				list.add(k);
			}
		}
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list.get(0));
		
	}

	public void swap(char candy[][], int a1, int b1, int a2, int b2) { 
		char tmp = candy[a1][b1];
		candy[a1][b1] = candy[a2][b2];
		candy[a2][b2] = tmp;
	}
	
	public int count(char candy[][]) {
		int longest1 = 1;
		for(int i=0; i< candy.length; i++) {
			int length = 1;
			for(int j=1; j< candy.length; j++) {
				if(candy[i][j]==candy[i][j-1]) {
					length++;
					if(longest1 < length) longest1 = length;
				}else {
					length = 1;
				}
			}
		}
		int longest2 = 1;
		for(int i=0; i< candy.length; i++) {
			int length = 1;
			for(int j=1; j< candy.length; j++) {
				if(candy[j][i] == candy[j-1][i]) {
					length++;
					if(longest2 < length) longest2 = length;
				}else {
					length = 1;
				}
			}
		}
		return Math.max(longest1, longest2);
	}

}