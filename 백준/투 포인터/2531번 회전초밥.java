import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int d = scan.nextInt();
		int k = scan.nextInt();
		int c = scan.nextInt();
		int arr[] = new int[n + k - 1];
		for(int i = 0; i < n; i++) arr[i] = scan.nextInt();
		for(int i = n; i <n + k - 1; i++) arr[i] = arr[i - n];
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int left = 0;
		int right = k - 1;
		map.put(c, 1);
		
		for(int i = left; i <= right; i++) {
			if(map.containsKey(arr[i])) {
				map.replace(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		
		int max = map.size();
		right++;
		left++;
		
		while(right < arr.length) {
			if(map.get(arr[left - 1]) == 1) {
				map.remove(arr[left - 1]);
			} else {
				map.replace(arr[left - 1], map.get(arr[left - 1]) -1);
			}
			
			if(map.containsKey(arr[right])) {
				map.replace(arr[right], map.get(arr[right]) + 1);
			} else {
				map.put(arr[right], 1);
			}
			
			if(max < map.size()) max = map.size();
			
			left++;
			right++;
		}
		
		System.out.println(max);
	}
}