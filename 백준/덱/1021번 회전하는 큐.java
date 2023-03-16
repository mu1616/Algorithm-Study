import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private int result = 0;
    private Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        for (int i = 0; i < m; i++) {
            int num = scanner.nextInt();
            int location = getLocation(num);
            if (location <= ((deque.size() / 2) + 1)) {
                calc2(num);
            } else {
                calc3(num);
            }
            deque.pollFirst();
        }
        System.out.println(result);
    }

    public int getLocation(int num) {
        return deque.stream()
                .collect(Collectors.toList())
                .indexOf(num) + 1;
    }

    public void calc2(int targetNum) {
        while (deque.peekFirst() != targetNum) {
            deque.addLast(deque.pollFirst());
            result++;
        }
    }

    public void calc3(int targetNum) {
        while (deque.peekFirst() != targetNum) {
            deque.addFirst(deque.pollLast());
            result++;
        }
    }
}