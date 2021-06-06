import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solution();
    }

    public void solution() {
        int n = scan.nextInt();
        int arr[] = new int[n*n];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < n; i++) {
            pq.add(scan.nextInt());
        }
        for (int i = 0; i < n*n - n; i++) {
            int num = scan.nextInt();
            if (num > pq.peek()) {
                pq.poll();
                pq.add(num);
            }
        }
        System.out.println(pq.peek());
    }
}
