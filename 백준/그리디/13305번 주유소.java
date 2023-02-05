import java.util.Scanner;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        int n = scanner.nextInt();
        int[] distArr = initArrayValues(n - 1);
        int[] costArr = initArrayValues(n);

        long sum = 0;
        int currentMinCost = Integer.MAX_VALUE;
        for (int location = 0; location < n - 1; location++) {
            if (currentMinCost > costArr[location]) {
                currentMinCost = costArr[location];
            }
            sum = sum + ((long) currentMinCost * distArr[location]);
        }
        System.out.println(sum);
    }

    public int[] initArrayValues(int size) {
        int[] values = new int[size];
        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }
        return values;
    }
}