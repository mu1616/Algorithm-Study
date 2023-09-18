import java.util.*;

public class Main {

    private final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            dp[i] = -1;
            for (int j = 0; j < i; j++) {
                if (arr[j] >= i - j && dp[j] != -1) {
                    dp[i] = dp[i] == -1 ? dp[j] + 1 : Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(dp[n - 1]);
    }
}
