import java.util.*;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            StringBuilder sb = new StringBuilder();
            cantor(n, sb);
            System.out.println(sb);
        }
    }

    public void cantor(int n, StringBuilder sb) {
        if (n == 0) {
            sb.append("-");
            return;
        }
        int cnt = (int) Math.pow(3, n);
        int cntPerSection = cnt / 3;

        cantor(n - 1, sb);
        sb.append(" ".repeat(Math.max(0, cntPerSection)));
        cantor(n - 1, sb);
    }
}