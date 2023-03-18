import java.util.*;

public class Main {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int x = scanner.nextInt();

        if (n == 1) {
            System.out.println("0");
            return;
        }

        Arrays.sort(arr);
        int result = 0;
        int leftPointer = 0;
        int rightPointer = n - 1;
        while (leftPointer != rightPointer) {
            int sum = arr[leftPointer] + arr[rightPointer];
            if (sum == x) {
                result++;
                rightPointer--;
                continue;
            }
            if (sum < x) {
                leftPointer++;
                continue;
            }
            rightPointer--;
        }
        System.out.println(result);
    }
}