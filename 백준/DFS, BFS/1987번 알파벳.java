import java.util.*;

class Main {
	HashSet<Character> st = new HashSet<>();
	ArrayList<Integer> resultList = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	char array[][];
	
	public static void main(String[] args) {
		Main m = new Main();
		m.solution();
	}

	public void solution() {
		int r = scan.nextInt();
		int c = scan.nextInt();
		array = new char[r][c];
		for (int i = 0; i < r; i++) {
			String tmp = scan.next();
			for (int j = 0; j < c; j++) {
				array[i][j] = tmp.charAt(j);
				st.add(tmp.charAt(j));
			}
		}
		recursion( 0, 0, 1);
		Collections.sort(resultList);
		System.out.println(resultList.get(resultList.size() - 1));
		
	}

	public void recursion(int x, int y, int result) {
		boolean end = true;
		if (x - 1 >= 0) {
			st.remove(new Character(array[x][y]));
			if (array[x-1][y]!=0 && st.contains(array[x - 1][y])) {
				char tmp = array[x][y];
				array[x][y] = 0;
				recursion( x - 1, y, result + 1);
				array[x][y] = tmp;
				end = false;
			}
			st.add(array[x][y]);
		}
		if (x + 1 < array.length) {
			st.remove(new Character(array[x][y]));
			if (array[x+1][y]!=0 && st.contains(array[x + 1][y])) {
				char tmp = array[x][y];
				array[x][y] = 0;
				recursion( x + 1, y, result + 1);
				array[x][y] = tmp;
				end = false;
			}
			st.add(array[x][y]);
		}
		if (y - 1 >= 0) {
			st.remove(new Character(array[x][y]));
			if (array[x][y-1] != 0 && st.contains(array[x][y - 1])) {
				char tmp = array[x][y];
				array[x][y] = 0;
				recursion( x, y - 1, result + 1);
				array[x][y] = tmp;
				end = false;
			}
			st.add(array[x][y]);
		}
		if (y + 1 < array[0].length) {
			st.remove(new Character(array[x][y]));
			if (array[x][y+1] !=0 && st.contains(array[x][y + 1])) {
				char tmp = array[x][y];
				array[x][y] = 0;
				recursion( x, y + 1, result + 1);
				array[x][y] = tmp;
				end = false;
			}
			st.add(array[x][y]);
		}
		if(end==true) {
			resultList.add(result);
		}
	}

}