import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int p = scan.nextInt();
		Melody melodyList[] = new Melody[n];
		for(int i = 0; i < n; i++) melodyList[i] = new Melody(scan.nextInt(), scan.nextInt());
		Stack<Integer> stacks[] = new Stack[7];
		for(int i = 0; i < 7; i++) stacks[i] = new Stack<Integer>();
		
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			Melody melody = melodyList[i];
			
			if(stacks[melody.string].isEmpty() || stacks[melody.string].peek() < melody.fret) {
				stacks[melody.string].push(melody.fret);
				cnt++;
				continue;
			}
			
			if(stacks[melody.string].peek() == melody.fret) {
				continue;
			}
			
			while(!stacks[melody.string].isEmpty() && stacks[melody.string].peek() > melody.fret) {
				stacks[melody.string].pop();
				cnt++;
			}
			
			if(stacks[melody.string].isEmpty() || stacks[melody.string].peek() != melody.fret) {
				stacks[melody.string].push(melody.fret);
				cnt++;		
			}
			
		}
		
		System.out.println(cnt);
	}
	
	class Melody {
		int string;
		int fret;
		
		Melody(int string, int fret) {
			this.string = string;
			this.fret = fret;
		}
	}

}