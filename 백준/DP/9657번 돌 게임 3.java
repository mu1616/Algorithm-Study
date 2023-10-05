import java.util.*;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        int n = scanner.nextInt();
        int[] dp = new int[1001];

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 0;
        dp[4] = 0;
        for (int i = 5; i <= 1000; i++) {
            if (dp[i - 1] == 0 && dp[i - 3] == 0 && dp[i - 4] == 0) {
                dp[i] = 1;
            } else {
                dp[i] = 0;
            }
        }
        System.out.println(dp[n] == 0 ? "SK" : "CY");
    }
}
