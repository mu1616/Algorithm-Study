import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws NumberFormatException, IOException {
		Main m = new Main();
		m.solution();
	}

	public void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Top> tops = new Stack<>();
		StringBuffer str = new StringBuffer("");
		for (int i = 0; i < n; i++) {
			Top t = new Top(Integer.parseInt(st.nextToken()), i + 1);
			while (!tops.isEmpty()) {
				Top top = tops.peek();
				if (t.height < top.height) {
					str.append(top.index + " ");
					break;
				}
				tops.pop();

			}
			if (tops.isEmpty())
				str.append("0 ");
			tops.push(t);

		}
		System.out.println(str.toString());
		br.close();
	}
}

class Top {
	int height;
	int index;

	Top(int height, int index) {
		this.height = height;
		this.index = index;
	}
}
