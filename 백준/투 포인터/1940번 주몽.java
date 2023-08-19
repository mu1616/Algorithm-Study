import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    public void solve() throws IOException {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if (n == 1) {
            System.out.println(0);
            return;
        }

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int answer = 0;
        int leftPointer = 0;
        int rightPointer = arr.length - 1;

        while(leftPointer < rightPointer) {
            int sum = arr[leftPointer] + arr[rightPointer];
            if (sum == m) {
                answer++;
                leftPointer++;
                rightPointer--;
                continue;
            }
            if (sum > m) {
                rightPointer--;
                continue;
            }
            leftPointer++;
        }
        System.out.println(answer);
    }
}
