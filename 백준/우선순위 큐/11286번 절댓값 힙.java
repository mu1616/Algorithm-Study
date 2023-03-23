import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        int n = scanner.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
            return (Math.abs(n1) != Math.abs(n2)) ?
                    Integer.compare(Math.abs(n1), Math.abs(n2)) :
                    Integer.compare(n1, n2);
        });
        
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (x == 0) {
                System.out.println(pq.isEmpty() ? "0" : pq.poll());
            } else {
                pq.add(x);
            }
        }
    }
}