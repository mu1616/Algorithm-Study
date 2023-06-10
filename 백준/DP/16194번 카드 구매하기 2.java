import java.io.*;
import java.util.*;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    public void solve() throws IOException {
        int n = scanner.nextInt();
        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = scanner.nextInt();
        }

        int[] dp = new int[n + 1];
        dp[1] = p[1];

        for (int i = 2; i <= n; i++) {
            dp[i] = p[i];
            for (int j = 1; j < i; j++) {
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }

        System.out.println(dp[n]);
    }
}