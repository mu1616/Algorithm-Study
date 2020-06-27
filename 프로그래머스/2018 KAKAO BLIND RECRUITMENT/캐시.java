import java.util.*;
class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (map.containsKey(city) && cacheSize != 0) {
                map.replace(city, 1000000);
                answer += 1;
            } else if (map.size() < cacheSize) {
                map.put(city, 1000000);
                answer += 5;

            } else {
                lru(city);
                answer += 5;
            }

            Iterator<String> keys = map.keySet().iterator();
            while (keys.hasNext()) {
                String key = keys.next();
                map.replace(key, map.get(key) - 1);
            }
        }

        return answer;
    }

    public void lru(String city) {
        Iterator<String> keys = map.keySet().iterator();
        int min = 1000000;
        String remove = null;
        while (keys.hasNext()) {
            String key = keys.next();
            int value = map.get(key);
            if (min > value) {
                min = value;
                remove = key;
            }
        }

        map.remove(remove);
        map.put(city, 1000000);
    }
}
