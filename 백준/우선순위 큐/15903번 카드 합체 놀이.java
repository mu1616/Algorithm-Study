
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    public void solve() throws IOException {
        long n = scanner.nextInt();
        long m = scanner.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a));
        for (int i = 0; i < n; i++) {
            pq.offer(scanner.nextLong());
        }
        for (int i = 0; i < m; i++) {
            long n1 = pq.poll();
            long n2 = pq.poll();
            long sum = n1 + n2;
            pq.offer(sum);
            pq.offer(sum);
        }
        long result = pq.stream()
                .mapToLong(Long::valueOf)
                .sum();
        System.out.println(result);
    }
}