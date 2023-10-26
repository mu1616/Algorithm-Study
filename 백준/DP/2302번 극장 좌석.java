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
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Set<Integer> vipSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            vipSet.add(scanner.nextInt());
        }

        int[] dp = new int[41];
        dp[1] = 1;
        dp[2] = vipSet.contains(2) || vipSet.contains(1) ? 1 : 2;
        for (int i = 3; i <= 40; i++) {
            if (vipSet.contains(i - 1) || vipSet.contains(i)) {
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
    }
}