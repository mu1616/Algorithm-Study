import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solution();
    }

    public void solution() {
        int n = scanner.nextInt();
        char[][] arr = createArr(n);
        fillStar(0, arr.length - 1, arr);
        printStar(arr);
    }

    public char[][] createArr(int n) {
        char[][] arr = new char[n * 4 - 3][n * 4 - 3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = ' ';
            }
        }
        return arr;
    }

    public void fillStar(int start, int end, char[][] arr) {
        if (start > end) {
            return;
        }
        for (int i = start; i <= end; i++) {
            arr[start][i] = '*';
            arr[end][i] = '*';
            arr[i][start] = '*';
            arr[i][end] = '*';
        }
        fillStar(start + 2, end - 2, arr);
    }

    public void printStar(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

}
