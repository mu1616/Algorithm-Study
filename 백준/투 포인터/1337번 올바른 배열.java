import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        int n = scanner.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(scanner.nextInt());
        }

        List<Integer> list = set.stream()
                .sorted()
                .collect(Collectors.toList());

        int result = 4;
        for (int start = 0; start < list.size(); start++) {
            int cnt = 4;
            int end = start + 1;    
            while (end < list.size() && list.get(end) - list.get(start) <= 4) {
                cnt = cnt - 1;
                result = Math.min(result, cnt);
                end++;
            }
        }

        System.out.println(result);
    }
}