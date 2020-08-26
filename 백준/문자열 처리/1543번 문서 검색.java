import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		String doc = scan.nextLine();
		String word = scan.nextLine();
		int result = 0;

		for(int i = 0; i <= doc.length() - word.length(); i++) {
			boolean possible = true;

			for(int j = 0; j < word.length(); j++) {
				if(word.charAt(j) != doc.charAt(i + j)) {
					possible = false;
					break;
				}
			}
			
			if(possible) {
				result++;
				i = i + word.length() - 1;
			}

		}
		
		System.out.println(result);
	}

}