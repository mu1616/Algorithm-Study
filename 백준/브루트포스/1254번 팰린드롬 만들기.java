import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
			
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		String str = scan.next();
		char arr[] = str.toCharArray();
		
		int index = 0;
		for(int i = 0; i < str.length(); i++) {
			StringBuffer sb = new StringBuffer(str.substring(i));
			if(sb.toString().equals(sb.reverse().toString())) {
				index = i;
				System.out.println(str.length() + i);
				break;
			}
		}
		
	}
}