import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solution();
    }

    public void solution() {
        int n = scan.nextInt();
        int m = scan.nextInt();
        int arr1[][] = new int[n][m];
        int arr2[][] = new int[n][m];

        // input
        for (int i = 0; i < n; i++) {
            String input = scan.next();
            for (int j = 0; j < m; j++) {
                arr1[i][j] = Integer.parseInt(input.substring(j, j + 1));
            }
        }
        for (int i = 0; i < n; i++) {
            String input = scan.next();
            for (int j = 0; j < m; j++) {
                arr2[i][j] = Integer.parseInt(input.substring(j, j + 1));
            }
        }
        //
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (arr1[i][j] != arr2[i][j]) {
                    reverse(arr1, j, i);
                    count++;
                }
            }
        }

        boolean isSame = true;
        loop :
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (arr1[i][j] != arr2[i][j]) {
                    isSame = false;
                    break loop;
                }
            }
        }

        System.out.println(isSame ? count : -1);
    }

    public void reverse(int arr[][], int x, int y) {
        for (int i = y; i < y + 3; i++) {
            for (int j = x; j < x + 3; j++) {
                arr[i][j] = arr[i][j] == 1 ? 0 : 1;
            }
        }
    }
}
