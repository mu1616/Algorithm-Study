import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solution();
    }

    public void solution() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] holeSizes = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            holeSizes[i] = scanner.nextInt();
        }

        int max = 0;
        int currentTotalSize = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < n && rightIndex < n) {
            if (currentTotalSize > m) {
                leftIndex++;
                currentTotalSize = currentTotalSize - holeSizes[leftIndex - 1];
            } else {
                rightIndex++;
                currentTotalSize = currentTotalSize + holeSizes[rightIndex];
            }
            if (currentTotalSize <= m) {
                max = Math.max(max, currentTotalSize);
            }
        }
        System.out.println(max);
    }
}