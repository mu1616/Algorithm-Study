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
        int m = scanner.nextInt();
        int arr[][] = new int[n + 1][m + 1];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int sum[][] = new int[n + 1][m + 1];
        for (int i = 1; i < sum.length; i++) {
            for (int j = 1; j < sum[0].length; j++) {
                sum[i][j] = sum[i][j - 1] + arr[i][j];
            }
        }

        int k = scanner.nextInt();
        for (int cnt = 0; cnt < k; cnt++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(getAnswer(arr, sum, i, j, x, y));
        }
    }

    public int getAnswer(int arr[][], int sum[][], int x1, int y1, int x2, int y2) {
        int answer = 0;
        for (int i = x1; i <= x2; i++) {
            answer = answer + sum[i][y2] - sum[i][y1 - 1];
        }
        return answer;
    }
}
