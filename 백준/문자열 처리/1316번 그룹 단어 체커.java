import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Main m = new Main();
		m.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		String array[] = new String[n];
		for(int i=0; i< n; i++)
			array[i] = scan.next();
		
		int cnt = 0;
		for(int i=0; i< n; i++) {
			if(check(array[i])) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	
	public boolean check(String str) {
		int visited[] = new int[26];
		visited[str.charAt(0)-'a'] = 1;
		char before = str.charAt(0);
		for(int i=1; i< str.length(); i++) {
			char curr = str.charAt(i);
			if(curr == before) {
				continue;
			} else {
				if(visited[curr-'a'] == 0) {
					visited[curr-'a'] = 1;
					before = curr;
				}else {
					return false;
				}
			}		
		}
		return true;
	}
}