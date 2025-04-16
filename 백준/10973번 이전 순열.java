import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solution();
    }

    //
    // 931
    public void solution() {
        int n = scanner.nextInt();
        Integer arr[] = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Integer targetIndex = null;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                targetIndex = i;
                break;
            }
        }
        if (targetIndex == null) {
            System.out.println("-1");
            return;
        }
        Integer swapIndex = null;
        int max = Integer.MIN_VALUE;
        for (int i = targetIndex; i < n; i++) {
            if (arr[i] < arr[targetIndex] && arr[i] > max) {
                max = arr[i];
                swapIndex = i;
            }
        }
        int temp = arr[targetIndex];
        arr[targetIndex] = arr[swapIndex];
        arr[swapIndex] = temp;
        Arrays.sort(arr, targetIndex + 1, n, Comparator.reverseOrder());
        System.out.println(Arrays.stream(arr)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}