import java.util.*;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        int n = Integer.parseInt(scanner.nextLine());
        List<Queue<String>> queues = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            queues.add(new LinkedList<>());
        }

        for (int i = 0; i < n; i++) {
            Queue<String> queue = queues.get(i);
            String str = scanner.nextLine();
            queue.addAll(Arrays.asList(str.split(" ")));
        }
        String[] resultWords = scanner.nextLine().split(" ");

        boolean success = true;
        loop:
        for (String resultWord : resultWords) {
            for (Queue<String> queue : queues) {
                if (!queue.isEmpty() && queue.peek().equals(resultWord)) {
                    queue.poll();
                    continue loop;
                }
            }
            success = false;
            break;
        }
        for (Queue<String> queue : queues) {
            if (!queue.isEmpty()) {
                success = false;
            }
        }
        System.out.println(success ? "Possible" : "Impossible");
    }

}
