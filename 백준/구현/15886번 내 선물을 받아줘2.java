import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		String str = scan.next();
		char map[] = str.toCharArray();
		
		int cnt = 0;
		for(int i = 0; i < map.length - 1; i++) {
			if(map[i + 1] == 'W' && map[i] == 'E') {
				cnt++;
			}
		}
		
		if(map[0] == 'W') cnt++;
		if(map[map.length - 1] == 'E') cnt++;
		
		System.out.println(cnt);
	}
	
	
}