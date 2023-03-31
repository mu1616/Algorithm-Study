import java.util.Scanner;

public class Main {

    private Scanner scanner = new Scanner(System.in);
    private String FORMAT = "w(%d, %d, %d) = %d";
    int[][][] dp = new int[51][51][51];

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        initDp();
        while (true) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (a == -1 && b == -1 && c == -1) {
                return;
            }
            System.out.println(String.format(FORMAT, a, b, c, w(a, b, c)));
        }
    }

    public void initDp() {
        for (int a = 0; a <= 50; a++) {
            for (int b = 0; b <= 50; b++) {
                for (int c = 0; c <= 50; c++) {
                    dp[a][b][c] = w(a, b, c);
                }
            }
        }
    }

    public int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20  || c > 20) {
            return dp[20][20][20];
        }
        if (a < b && b < c) {
            return dp[a][b][c - 1] + dp[a][b - 1][c - 1] - dp[a][b - 1][c];
        }
        return dp[a - 1][b][c] + dp[a - 1][b - 1][c] + dp[a - 1][b][c - 1] - dp[a - 1][b - 1][c - 1];
    }
}