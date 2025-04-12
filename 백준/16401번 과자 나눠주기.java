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
        int n = scanner.nextInt();
        int[] snackSizes = new int[n];
        for (int i = 0; i < n; i++) {
            snackSizes[i] = scanner.nextInt();
        }
        Arrays.sort(snackSizes);
        int start = 1;
        int end = snackSizes[snackSizes.length - 1];

        int answer = 0;
        while(true) {
            int mid = (start + end) / 2;
            int snackCount = getSnackCount(snackSizes, mid);
            if (snackCount >= m) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            if (start > end) {
                break;
            }
        }
        System.out.println(answer);
    }

    public int getSnackCount(int[] snackSizes, int cuttingSize) {
        return Arrays.stream(snackSizes)
                .reduce(0, (sum, snackSize) -> sum + (snackSize / cuttingSize));
    }
}