import java.util.*;
class Main {
	static Scanner scan = new Scanner(System.in);
	static int box[] = new int[9];
	public static void main(String[] args) {
		Main main = new Main();
		String n = scan.next();
		int count = 0;
		for(int i=0; i< n.length(); i++) {
			char tmp = n.charAt(i);
			if(tmp == 54 || tmp == 57) {
				if(box[6] > 0) {
					box[6]--;
				}else {
					buySet();
					count++;
					box[6]--;
				}
			}else {
				if(box[tmp-48]>0) {
					box[tmp-48]--;
				}else {
					buySet();
					count++;
					box[tmp-48]--;
				}
			}
		}
		System.out.println(count);
}
	static void buySet() {
		for(int i=0; i< box.length; i++) {
			box[i]++;
		}
		box[6]++;
	}
}