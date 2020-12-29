import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int array[];

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		array = new int[n];
		for (int i = 0; i < n; i++)
			array[i] = scan.nextInt();
		int total = scan.nextInt();

		int answer = 0;
		int left = 0;
		int right = total;
		
		if(canAssign(total)) {
			Arrays.sort(array);
			System.out.println(array[array.length - 1]);
			return;
		}
		
		while (left <= right) {
			int mid = (left + right) / 2;	
			
			int sum = Arrays.stream(array).reduce(0, (acc, num) -> {
				return (num > mid) ? acc + mid : acc + num;
			});	
			
			if (sum <= total) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(answer);
	}
	
	public boolean canAssign(int total) {
		int sum = Arrays.stream(array).reduce(0, (acc, num) -> acc + num);
		return sum <= total;
	}
}
