import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solution();
    }

    public void solution() {
        int n = scan.nextInt();
        int dp[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = -1;
                continue;
            }

            if (i - 2 >= 0 && dp[i - 2] != -1) {
                dp[i] = dp[i - 2] + 1;
            }

            if (i - 5 >= 0 && dp[i - 5] != -1) {
                dp[i] = dp[i - 5] + 1;
            }

            if (dp[i] == 0) {
                dp[i] = -1;
            }
        }

        System.out.println(dp[n]);
    }
}
