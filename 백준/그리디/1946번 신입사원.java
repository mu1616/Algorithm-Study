import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Main m = new Main();
		m.solution();
	}

	public void solution() {
		int t = scan.nextInt();
		for(int i=0; i< t; i++) {
			int n = scan.nextInt();
			ArrayList<P> people = new ArrayList<>();
			for(int j=0; j< n; j++) {
				P p = new P();
				p.a = scan.nextInt();
				p.b = scan.nextInt();
				people.add(p);
			}
			Collections.sort(people);
			//////////////////입력완료/////////////////////////
			int result = calculate(people);
			System.out.println(result);
		}
	}
	
	public int calculate(ArrayList<P> people) {
		int rightMax= people.get(0).b;
		int result = 1;
		for(int i=1; i< people.size(); i++) {
			P p = people.get(i);
			if(p.b < rightMax) {
				result++;	
				rightMax = p.b;
			}
		}
		return result;
	}
	
	class P implements Comparable<P>{
		int a;
		int b;
		@Override
		public int compareTo(P o) {
			if(this.a > o.a) {
				return 1;
			}else {
				return -1;
			}			
		}
	}



}