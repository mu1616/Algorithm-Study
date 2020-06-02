import java.util.*;

class Solution {
	static Scanner scan = new Scanner(System.in);
	HashMap<String, Integer> map;
	int sum = 0;

	public int solution(String[][] clothes) {
		int answer = 1;
		map = new HashMap<>();
		ArrayList<Cloth> list = new ArrayList<>();
		for (int i = 0; i < clothes.length; i++) {
			list.add(new Cloth(clothes[i][0], clothes[i][1]));
			if (map.get(clothes[i][1]) == null)
				map.put(clothes[i][1], 1);
			else
				map.put(clothes[i][1], map.get(clothes[i][1])+1);
		}
		Iterator<String> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			String key = keys.next();
			//System.out.println(map.get(keys.next()));
			answer = answer * (map.get(key)+1);
		}
		return answer-1;
	}

	class Cloth {
		String name;
		String type;

		Cloth(String name, String type) {
			this.name = name;
			this.type = type;
		}
	}

}