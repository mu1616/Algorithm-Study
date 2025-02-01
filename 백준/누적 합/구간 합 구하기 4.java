import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0 ; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        int[] sums = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            sums[i] = sums[i - 1] + numbers[i - 1];
        }
        for (int i = 0; i < m; i++) {
            int subtractNum = sums[scanner.nextInt() - 1];
            System.out.println(sums[scanner.nextInt()] - subtractNum);
        }
    }
}