import java.util.*;

public class Main {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Set<String> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            s.add(scanner.next());
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            if (s.contains(scanner.next())) {
                result++;
            }
        }
        System.out.println(result);
    }
}