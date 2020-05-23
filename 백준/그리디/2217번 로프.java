import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();

	}

	public void solution() {
		int n = scan.nextInt();
		Integer ropes[] = new Integer[n];
		for(int i=0; i< n; i++)
			ropes[i] = scan.nextInt();
		
		Arrays.sort(ropes, Collections.reverseOrder());
		ArrayList<Integer> list = new ArrayList<>();
		Integer p[] = new Integer[n];
		for(int i=0; i< n; i++) {
			p[i] = ropes[i] * (i+1);
		}
		Arrays.sort(p);
		System.out.println(p[n-1]);
	}
	


}