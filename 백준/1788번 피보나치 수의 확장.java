import java.util.*;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solution();
    }


    /*
    f(5) = 5
    f(-4) = -3
    f(-3) = 2
    f(-2) = -1
    f(-1) = 1
    f(0) = 0
    f(1) = 1
    f(2) = 1
    f(3) = 2
    f(4) = 3
    f(5) = 5
    f(n) = f(n - 1) + f(n - 2)
    f(n) = f(n + 2) - f(n + 1)
     */
    public void solution() {
        int n = scanner.nextInt();
        if (n == 0) {
            System.out.println("0");
            System.out.println("0");
            return;
        }

        long[] dp = new long[Math.abs(n) + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= dp.length - 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000000;
        }
        if (n < 0 && n % 2 == 0) {
            System.out.println("-1");
        } else {
            System.out.println("1");
        }
        System.out.println(dp[dp.length - 1]);
    }
}