import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    Map<String, Integer> map = new HashMap<>();
    Character[] arr = {'A', 'E', 'I', 'O', 'U'};
    Stack<Character> stack = new Stack<>();
    int cnt = 0;
    
    public int solution(String word) {
        recursive();
        return map.get(word);
    }

    public void recursive() {
        if (stack.size() > 0) {
            cnt++;
            map.put(getCurrentWord(), cnt);
        }
        if (stack.size() == 5) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
            recursive();
            stack.pop();
        }
    }

    private String getCurrentWord() {
        return stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}