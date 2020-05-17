import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
		
	}

	public void solution() {
		int n =scan.nextInt();
		Person []array = new Person[n];
		for(int i=0; i< n; i++) {
			array[i] = new Person();
			array[i].x = scan.nextInt();
			array[i].y = scan.nextInt();
		}
		for(int i=0; i< n; i++) {
			int cnt = 1;
			Person p1 = array[i];
			for (int j=0; j< n; j++) {
				Person p2 = array[j];
				if(p1.x < p2.x && p1.y < p2.y) {
					cnt = cnt + 1;
				}
			}
			p1.rate = cnt;
		}
		for(Person p : array) {
			System.out.println(p.rate);
		}
	}
	
	class Person{
		int x;
		int y;
		int rate;
	

	}


}