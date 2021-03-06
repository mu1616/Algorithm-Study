import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String [] args) {
        Main main = new Main();
        int t = scan.nextInt();
        for (int i = 0; i < t; i++)
            main.solution();
    }

    public void solution() {
        int n = scan.nextInt();
        long dp[] = new long[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i < 2) {
                dp[i] = 1;
                continue;
            }

            if (i == 2) {
                dp[i] = 2;
                continue;
            }

            if (i == 3) {
                dp[i] = 4;
                continue;
            }

            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4];
        }

        System.out.println(dp[n]);
    }
}
