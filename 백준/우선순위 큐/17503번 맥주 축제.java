import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int m = scan.nextInt();
		int k = scan.nextInt();

		Beer beers[] = new Beer[k];
		PriorityQueue<Beer> pq = new PriorityQueue<>((beer1, beer2) -> beer1.preference - beer2.preference);
		for (int i = 0; i < k; i++) {
			beers[i] = new Beer(scan.nextInt(), scan.nextInt());
		}

		Arrays.sort(beers, (beer1, beer2) -> beer1.level - beer2.level);

		int totalPreference = 0;
		for (int i = 0; i < k; i++) {
			if (pq.size() < n) {
				pq.offer(beers[i]);
				totalPreference += beers[i].preference;
			}
			
			if (pq.size() == n) {
				if (totalPreference >= m) {
					System.out.println(beers[i].level);
					return;
				} else {
					totalPreference -= pq.poll().preference;
				}
			}
		}
		
		System.out.println("-1");
	}

	class Beer {
		int preference;
		int level;

		Beer(int preference, int level) {
			this.preference = preference;
			this.level = level;
		}
	}
}
