import java.io.IOException;
import java.util.*;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        int n = scanner.nextInt();
        int dp[] = new int[50001];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                int square = j * j;
                if (square > i) {
                    break;
                }
                if (square == i) {
                    dp[i] = 1;
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}