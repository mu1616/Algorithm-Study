import java.util.*;

class Main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		Main m = new Main();
		String str = scanner.next();
		int flag = 0;
		char a = 'a';
		char z = 'z';
		for(int i=a; i<=z ; i++) {
			flag = 0;
			for(int j=0; j< str.length(); j++) {				
				if(str.charAt(j) == i) {
					System.out.print(j+" ");
					flag = 1;
					break;
				}
			}
			if(flag==0) System.out.print("-1 ");
		}
		//System.out.println(m.solution(phone_book));
	}
	

}