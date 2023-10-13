
import java.util.*;

public class Main {

    private final Scanner scanner = new Scanner(System.in);
    int[] l;
    int[] j;
    int result = 0;
    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        int n = scanner.nextInt();
        l = new int[n];
        j = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            j[i] = scanner.nextInt();
        }
        recursive(0, 100, 0);
        System.out.println(result);
    }

    public void recursive(int i, int hp, int pleasure) {
        if (i == l.length) {
            result = Math.max(result, pleasure);
            return;
        }

        recursive(i + 1, hp, pleasure);
        if (hp - l[i] > 0) {
            recursive(i + 1, hp - l[i], pleasure + j[i]);
        }
    }
}