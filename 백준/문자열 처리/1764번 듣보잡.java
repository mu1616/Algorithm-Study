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
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=0; i< n; i++) {
			String name = scan.next();
			map.put(name,1);
		}
		
		for(int i=0; i< m; i++) {
			String name = scan.next();
			if(map.containsKey(name)) {
				map.replace(name, 2);
			} else {
				map.put(name,1);
			}
		}
		
		Iterator<String> iterator = map.keySet().iterator();
		ArrayList<String> resultList = new ArrayList<>();
		
		while(iterator.hasNext()) {
			String name = iterator.next();
			if(map.get(name) ==2) 
				resultList.add(name);
		}
		
		Collections.sort(resultList);
		System.out.println(resultList.size());
		
		for(String t : resultList) {
			System.out.println(t);
		}
	}

}

