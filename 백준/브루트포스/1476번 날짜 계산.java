import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        int e = scanner.nextInt();
        int s = scanner.nextInt();
        int m = scanner.nextInt();

        int year = 1;
        while(((year -e) % 15 != 0) || ((year - s) % 28 != 0) || ((year - m) % 19 != 0)) {
            year++;
        }
        System.out.println(year);
    }
}