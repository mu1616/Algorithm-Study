import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        recursive(arr);
    }

    public int[][] pooling(int[][] arr) {
        int size = arr.length;
        int poolingSize = size / 2;
        int[][] poolingArr = new int[poolingSize][poolingSize];

        for (int i = 0; i < size; i = i + 2) {
            for (int j = 0; j < size; j = j + 2) {
                int secondMaxNumber = Stream.of(arr[i][j], arr[i][j + 1], arr[i + 1][j], arr[i + 1][j + 1])
                        .sorted(Comparator.comparingInt((Integer n) -> n).reversed())
                        .collect(Collectors.toList())
                        .get(1);
                poolingArr[i / 2][j / 2] = secondMaxNumber;
            }
        }
        return poolingArr;
    }

    public void recursive(int [][] arr) {
        if (arr.length == 1) {
            System.out.println(arr[0][0]);
            return;
        }
        recursive(pooling(arr));
    }
}
