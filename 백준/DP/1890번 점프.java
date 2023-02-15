import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    int [][] board;
    long [][] dp;

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        int n = scanner.nextInt();
        board = createBoard(n);
        dp = new long[n][n];

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                dp[i][j] = getRoute(i, j);
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }

    public long getRoute(int row, int col) {
        long route = 0;
        for (int i = row - 1; i >=0; i--) {
            if (board[i][col] == (row - i)) {
                route = route + dp[i][col];
            }
        }
        for (int i = col - 1; i >= 0; i--) {
            if (board[row][i] == (col - i)) {
                route = route + dp[row][i];
            }
        }
        return route;
    }

    public int[][] createBoard(int size) {
        int[][] board = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        return board;
    }
}