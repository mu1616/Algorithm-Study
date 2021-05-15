import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);
    int count[] = new int[3];

    public static void main(String[] args) {
        Main main = new Main();
        main.solution();
    }

    public void solution() {
        int n = scan.nextInt();
        int paper[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                paper[i][j] = scan.nextInt();
            }
        }

        recursion(paper, 0, 0, n);
        for (int i = 0 ; i < 3; i++) {
            System.out.println(count[i]);
        }
    }

    public void recursion(int paper[][], int x, int y, int size) {
        if (size == 0) {
            return;
        }
        int number = paper[y][x];
        boolean success = true;
        loop :
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (number != paper[i][j]) {
                    success = false;
                    break loop;
                }
            }
        }

        if (success) {
            count[number + 1] += 1;
        } else {
            int nextSize = size / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    recursion(paper, x + nextSize * i, y + nextSize * j, nextSize);
                }
            }
        }
    }
}
