import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Main m = new Main();
		m.solution();
	}

	public void solution() {
		String a = scan.next();
		String b = scan.next();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i< b.length()-a.length()+1; i++) {
			int cnt = 0;
			String tmp = b.substring(i,i+a.length());
			for(int j=0; j< a.length(); j++) {
				if(a.charAt(j)!=tmp.charAt(j))
					cnt = cnt + 1;
			}
			list.add(cnt);
		}
		Collections.sort(list);
		System.out.println(list.get(0));
	}



}