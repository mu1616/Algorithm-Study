import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		String str = scan.next();
		StringBuilder k = new StringBuilder("");
		k.append(str.substring(0,1));
		for(int i=1; i< str.length(); i++) {
			if(str.charAt(i)== '-') {
				k.append(str.substring(i+1,i+2));
			}
		}
		System.out.println(k);
	}



}