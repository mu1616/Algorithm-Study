import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int arr[] = new int[n];
		PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
			return n1 - n2;
		});
		
		for(int i = 0; i < n; i++) {
			pq.offer(scan.nextInt());
		}
		
		int sum = 0;
		while(true) {
			if(pq.size() == 1) {
				break;
			}
			
			int n1 = pq.poll();
			int n2 = pq.poll();
			sum += n1 + n2;
			pq.offer(n1 + n2);
		}
		
		System.out.println(sum);
	}
}