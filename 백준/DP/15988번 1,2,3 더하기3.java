import java.util.Scanner;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        int t = scanner.nextInt();
        long dp[] = new long[1000000];

        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
        }

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            System.out.println(dp[n - 1]);
        }
    }
}