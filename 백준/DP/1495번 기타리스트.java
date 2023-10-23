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
        int s = scanner.nextInt();
        int m = scanner.nextInt();
        int[] volumes = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            volumes[i] = scanner.nextInt();
        }

        boolean dp[][] = new boolean[n + 1][m + 1];
        dp[0][s] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (!dp[i - 1][j]) {
                    continue;
                }
                if (j + volumes[i] <= m) {
                    dp[i][j + volumes[i]] = true;
                }
                if (j - volumes[i] >= 0) {
                    dp[i][j - volumes[i]] = true;
                }
            }
        }
        for (int i = m; i >= 0; i--) {
            if (dp[n][i]) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
