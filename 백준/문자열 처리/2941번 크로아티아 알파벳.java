import java.io.*;
import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.solution();

	}

	public void solution() {
		String cro[] = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		String str = scan.next();
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (i < str.length() - 1) {
				String tmp = str.substring(i, i + 2);
				if (isCro(cro, tmp)) {
					i = i + 1;
				}
			}
			if (i < str.length() - 2) {
				String tmp = str.substring(i, i + 3);
				if (isCro(cro, tmp)) {
					i = i + 2;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}

	public boolean isCro(String[] cro, String str) {
		for (int i = 0; i < cro.length; i++) {
			if (cro[i].equals(str)) {
				return true;
			}
		}
		return false;
	}

}