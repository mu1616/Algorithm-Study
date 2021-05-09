import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solution();
    }

    public void solution() {
        String str1 = scan.next();
        String str2 = scan.next();

        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        int max = 0;

        for (int i = 1; i < str1.length() + 1; i++) {
            char char1 = str1.charAt(i - 1);
            for (int j = 1; j < str2.length() + 1; j++) {
                if (char1 == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }  else {
                    dp[i][j] = Math.max(dp[i -1][j], dp[i][j - 1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);
    }
}
