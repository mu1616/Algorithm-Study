import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int max = 0;
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		Egg eggs[] = new Egg[n];
		for(int i = 0; i < n; i++) {
			eggs[i] = new Egg(scan.nextInt(), scan.nextInt());
		}
		
		recursion(eggs, 0, 0);
		System.out.println(max);
	}
	
	public void recursion(Egg eggs[], int curr, int hit) {
		if(curr == eggs.length) {
			if(max < hit) max = hit;
			return;
		}
		
		if(eggs[curr].hp <= 0) {
			recursion(eggs, curr + 1, hit);
			return;
		}
		
		boolean possible = false;
		for(int i = 0; i < eggs.length; i++) {
			if(i == curr) continue;
			if(eggs[i].hp <= 0) continue;
			
			possible = true;
			int nextHit = hit;
			eggs[curr].hp -= eggs[i].weight;
			eggs[i].hp -= eggs[curr].weight;
			if(eggs[curr].hp <= 0) nextHit++;
			if(eggs[i].hp <= 0) nextHit++;
			
			recursion(eggs, curr + 1, nextHit);
			
			eggs[curr].hp += eggs[i].weight;
			eggs[i].hp += eggs[curr].weight;
		}
		
		if(!possible) {
			recursion(eggs, curr + 1, hit);
		}
	}
	
	class Egg {
		int weight;
		int hp;
		
		Egg(int hp, int weight) {
			this.hp = hp;
			this.weight = weight;
		}
	}
}