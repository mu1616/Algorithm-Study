import java.io.*;
import java.util.*;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    public void solve() throws IOException {
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        long[] lines = new long[k];
        for (int i = 0;  i < k; i++) {
            lines[i] = scanner.nextInt();
        }
        Arrays.sort(lines);
        long left = 1;
        long right = lines[lines.length - 1];
        long result = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long cuttingLineCount = getCuttingLineCount(lines, mid);
            if (cuttingLineCount >= n) {
                result = mid;
            }
            if (cuttingLineCount < n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }

    public long getCuttingLineCount(long[] lines, long cuttingLength) {
        return Arrays.stream(lines)
                .map(line -> line / cuttingLength)
                .sum();
    }
}