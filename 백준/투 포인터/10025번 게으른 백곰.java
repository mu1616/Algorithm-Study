import java.util.*;

public class Main {

    private final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[10000001];
        for (int i = 0; i < n; i++) {
            int g = scanner.nextInt();
            int x = scanner.nextInt();
            arr[x] = g;
        }

        if (k >= 500000) {
            System.out.println(Arrays.stream(arr).sum());
            return;
        }

        int left = -k;
        int right = k;
        int sum = 0;
        for (int i = 0; i <= k; i++) {
            sum = sum + arr[i];
        }
        int answer = sum;
        for (int i = 0; i <= 1000001; i++) {
            right = right + 1;
            if (right <= 1000001) {
                sum = sum + arr[right];
            }
            left = left + 1;
            if (left > 0) {
                sum = sum - arr[left - 1];
            }
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }
}
