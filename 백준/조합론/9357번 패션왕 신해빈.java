import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    public void solve() throws IOException {
        int testCase = scanner.nextInt();
        for (int i = 0; i < testCase; i++) {
            Map<String, Integer> map = new HashMap<>();
            int n = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                String name = scanner.next();
                String kind = scanner.next();
                map.put(kind, map.getOrDefault(kind, 0) + 1);
            }

            int result = 1;
            for (String kind : map.keySet()) {
                result = result * (map.get(kind) + 1);
            }
            System.out.println(result - 1);
        }
    }
}