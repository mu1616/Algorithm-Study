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
        int n = scanner.nextInt();

        Min[] dp = new Min[1000001];
        dp[1] = new Min(0, "1");
        dp[2] = new Min(1, "2 1");
        dp[3] = new Min(1, "3 1");

        for (int i = 4; i <= 1000000; i++) {
            Min min = new Min(dp[i - 1].count + 1, i + " " + dp[i - 1].numbers);
            if (i % 2 == 0 && dp[i / 2].count < min.count - 1) {
                min = new Min(dp[i / 2].count + 1, i + " " + dp[i / 2].numbers);
            }
            if (i % 3 == 0 && dp[i / 3].count < min.count - 1) {
                min = new Min(dp[i / 3].count + 1, i + " " + dp[i / 3].numbers);
            }
            dp[i] = min;
        }

        System.out.println(dp[n].count);
        System.out.println(dp[n].numbers);
    }

    static class Min {
        long count;
        String numbers;

        public Min(long count, String numbers) {
            this.count = count;
            this.numbers = numbers;
        }
    }
}
