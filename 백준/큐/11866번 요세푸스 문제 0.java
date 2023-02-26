import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        Queue<Integer> queue = createQueue(n);
        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.poll());
            }
            result.add(String.valueOf(queue.poll()));
        }

        System.out.println(
                result.stream().collect(Collectors.joining(", ", "<", ">"))
        );
    }

    public Queue<Integer> createQueue(int n) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        return queue;
    }
}