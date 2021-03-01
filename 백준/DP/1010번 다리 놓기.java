import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);
    int dp[][];

    public static void main(String [] args) {
        Main main = new Main();
        int t = scan.nextInt();
        for (int i = 0; i < t; i++)
            main.solution();
    }

    public void solution() {
        int n = scan.nextInt();
        int m = scan.nextInt();
        dp = new int[m +1][m +1];
        System.out.println(combi(m, n));
    }

    public int combi(int n, int r) {
        if (dp[n][r] != 0) return dp[n][r];
        if (n == r) return 1;
        if (r == 0) return 1;
        int combi = combi(n - 1, r) + combi(n - 1, r - 1);
        dp[n][r] = combi;
        return combi;
    }
}
