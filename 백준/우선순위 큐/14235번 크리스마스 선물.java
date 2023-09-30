import java.util.*;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        int n = scanner.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            if (a == 0) {
                System.out.println(pq.isEmpty() ? "-1" : pq.poll());
                continue;
            }
            for (int j = 0; j < a; j++) {
                pq.add(scanner.nextInt());
            }
        }
    }
}
