import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    public void solve() throws IOException {
        long divisor = 1000000009;
        long dp[][] = new long[100001][4];

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for (int i = 4; i < 100001; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % divisor;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % divisor;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % divisor;
        }

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            System.out.println((dp[n][1] + dp[n][2] + dp[n][3]) % divisor);
        }
    }
}