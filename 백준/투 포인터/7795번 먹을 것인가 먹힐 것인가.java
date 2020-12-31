import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		int t = scan.nextInt();
		for (int i = 0; i < t; i++)
			main.solution();
	}

	public void solution() {
		int a = scan.nextInt();
		int b = scan.nextInt();
		int arrayA[] = new int[a];
		int arrayB[] = new int[b];
		
		for (int i = 0; i < a; i++) {
			arrayA[i] = scan.nextInt();
		}
		for (int i = 0; i < b; i++) {
			arrayB[i] = scan.nextInt();
		}
		
		Arrays.sort(arrayA);
		Arrays.sort(arrayB);
		
		int indexB = 0;
		int cnt = 0;
		for(int i = 0; i < a; i++) {
			cnt += indexB;
			for(int j = indexB; j < b; j++) {
				if (arrayA[i] > arrayB[j]) {
					cnt++;
				} else {
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
