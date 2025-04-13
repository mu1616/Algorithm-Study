import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solution();
    }

    public void solution() {
        int m = scanner.nextInt();
        int[] stones = new int[m + 1];
        int count = 0;
        for (int i = 1; i < stones.length; i++) {
            stones[i] = scanner.nextInt();
            count = count + stones[i];
        }
        int k = scanner.nextInt();

        BigDecimal result = BigDecimal.valueOf(0);
        for (int i = 1; i < stones.length; i++) {
            if (stones[i] < k) {
                continue;
            }
            BigDecimal subResult = BigDecimal.valueOf(1);
            for (int j = 0; j < k; j++) {
                subResult = subResult.multiply(
                        (BigDecimal.valueOf(stones[i] - j).divide(BigDecimal.valueOf(count - j), 30, RoundingMode.HALF_UP))
                );
            }
            result = result.add(subResult);
        }
        System.out.println(result);
    }
}