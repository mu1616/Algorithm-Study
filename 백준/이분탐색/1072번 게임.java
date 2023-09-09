import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    public void solve() throws IOException {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int currentWinRate = BigDecimal.valueOf(y)
                .divide(BigDecimal.valueOf(x), 10, RoundingMode.DOWN)
                .multiply(BigDecimal.valueOf(100))
                .intValue();
        if (currentWinRate >= 99) {
            System.out.println("-1");
            return;
        }

        int left = 1;
        int right = (int) x;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int winRate = BigDecimal.valueOf(y + mid)
                    .divide(BigDecimal.valueOf(x + mid), 10, RoundingMode.DOWN)
                    .multiply(BigDecimal.valueOf(100))
                    .intValue();
            if (winRate > currentWinRate) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
