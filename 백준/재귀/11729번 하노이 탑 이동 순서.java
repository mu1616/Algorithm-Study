import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private int count = 0;
    private StringBuilder sb = new StringBuilder("");
    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        int n = scanner.nextInt();
        move(1, 3, 2, n);
        System.out.println(count);
        System.out.println(sb.toString());
    }

    /**
     * size 크기의 탑을 start 에서 destination 으로 옮긴다.
     */
    public void move(int start, int destination, int other, int size) {
        if (size == 1) {
            sb.append(start).append(" ").append(destination).append("\n");
            count++;
            return;
        }
        if (size >= 2) {
            move(start, other, destination, size - 1);
            move(start, destination, other, 1);
            move(other, destination, start, size - 1);
        }
    }
}