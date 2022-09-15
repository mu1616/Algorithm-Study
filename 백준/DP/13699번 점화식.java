import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solution();
    }

    public void solution() {
        long[] arr = new long[36];
        arr[0] = 1;
        for (int i = 1; i <= 35; i++) {
            arr[i] = 0;
            for (int j = 0; j < i; j++) {
                arr[i] = arr[i] + (arr[j] * arr[i - j - 1]);
            }
        }

        int n = scanner.nextInt();
        System.out.println(arr[n]);
    }
}
