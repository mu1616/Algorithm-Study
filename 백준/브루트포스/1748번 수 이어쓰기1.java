import java.io.*;
import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.solution();

	}

	public void solution() {
		int n = scan.nextInt();
		int cnt = 0;
		for(int i=1; i<= n; i++) {
			int len = 1;
			int num = i;
			while(true) {
				num = num/10;
				if(num==0) {
					break;
				}else {
					len++;
				}
			}
			cnt = cnt + len;
		}
		System.out.println(cnt);
	}
	
}