import java.util.*;

class Main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		Main m = new Main();
		String str = scanner.nextLine();
		str = str.trim();
		if(str.length() ==0) System.out.println("0");
		else {
			String [] array = str.split(" ");
			System.out.println(array.length);
		}
		//System.out.println(m.solution(phone_book));
	}
	

}