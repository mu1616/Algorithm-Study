import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private final Scanner scanner = new Scanner(System.in);
    private static final String IMPOSSIBLE = "I'm Sorry Hansoo";
    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        String str = scanner.next();
        if (str.length() == 1) {
            System.out.println(str);
            return;
        }
        char[] arr = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : arr) {
            map.merge(c, 1, Integer::sum);
        }
        if (!palindromePossible(map)) {
            System.out.println(IMPOSSIBLE);
            return;
        }
        System.out.println(getFront(map) + getMid(map) + getBack(map));
    }

    private boolean palindromePossible(Map<Character, Integer> map) {
        Set<Character> keySet = map.keySet();
        int oddCount = 0;
        for (Character c : keySet) {
            if (map.get(c) % 2 == 1) {
                oddCount++;
            }
        }
        return oddCount <= 1;
    }

    private String getMid(Map<Character, Integer> map) {
        Set<Character> keySet = map.keySet();
        for (Character c : keySet) {
            if (map.get(c) % 2 == 1) {
                return String.valueOf(c);
            }
        }
        return "";
    }

    private String getBack(Map<Character, Integer> map) {
        StringBuilder sb = new StringBuilder("");
        List<Character> reserveSortedKeys = map.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        for (Character c : reserveSortedKeys) {
            int value = map.get(c);
            for (int i = 0; i < value / 2; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private String getFront(Map<Character, Integer> map) {
        StringBuilder sb = new StringBuilder("");
        List<Character> sortedKeys = map.keySet().stream()
                .sorted()
                .collect(Collectors.toList());
        for (Character c : sortedKeys) {
            int value = map.get(c);
            for (int i = 0; i < value / 2; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
