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
		for(int i = 0; i < n; i++) arr[i] = scan.nextInt();
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int arr2[] = Arrays.stream(arr).distinct().sorted().toArray();
		
		for(int i = 0; i < arr2.length; i++) map.put(arr2[i], i);
		
		StringBuilder sb = new StringBuilder();
		for(int i : arr)
			sb.append(map.get(i)+" ");
		
		System.out.println(sb.toString());
	}
}