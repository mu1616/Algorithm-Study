import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private final Scanner scanner = new Scanner(System.in);
    int dp[][];

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = j == 0 ? board[i][j] : dp[i][j - 1] + board[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sb.append(getSectionSum(x1, y1, x2, y2) + "\n");
        }
        System.out.println(sb);
    }

    public int getSectionSum(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            return getLineSectionSum(x1, y1, y2);
        }
        int sum = 0;
        for (int i = x1; i <= x2; i++) {
            sum = sum + getLineSectionSum(i, y1, y2);
        }
        return sum;
    }

    public int getLineSectionSum(int x, int y1, int y2) {
        if (y1 == 1) {
            return dp[x - 1][y2 - 1];
        }
        return dp[x - 1][y2 - 1] - dp[x - 1][y1 - 2];
    }
}