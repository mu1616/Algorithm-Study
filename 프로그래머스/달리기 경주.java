import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        for (String call : callings) {
            int i = map.get(call);
            swap(players, i);
            map.put(call, i - 1);
            map.put(players[i], i);
        }
        return players;
    }
    
    public void swap(String[] players, int i) {
        String temp = players[i];
        players[i] = players[i - 1];
        players[i - 1] = temp;
    }
}