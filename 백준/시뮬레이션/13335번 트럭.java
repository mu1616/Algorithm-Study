import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
			
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int w = scan.nextInt();
		int l = scan.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n ; i++) arr[i] = scan.nextInt();
		
		Queue<Truck> queue = new LinkedList<>();
		for(int i : arr) queue.offer(new Truck(i));
		
		Queue<Truck> bri = new LinkedList<>(); 
		int time = 0;
		int currWeight = 0;
		
		while(!bri.isEmpty() || !queue.isEmpty()) {
			drive(bri);
			
			if(!bri.isEmpty() && bri.peek().location == w + 1) {
				currWeight -= bri.poll().weight;
			}
			
			if(!queue.isEmpty() && l - currWeight >= queue.peek().weight) {
				Truck truck = queue.poll();
				currWeight += truck.weight;
				bri.offer(truck);
			}
			
			time++;
		}
		
		System.out.println(time);
	}
	
	public void drive(Queue<Truck> bri) {
		for(int i = 0; i < bri.size(); i++) {
			Truck truck = bri.poll();
			truck.location += 1;
			bri.offer(truck);
		}
	}
	
	class Truck {
		int weight;
		int location = 1;
		Truck(int weight) {
			this.weight = weight;
		}
	}
}