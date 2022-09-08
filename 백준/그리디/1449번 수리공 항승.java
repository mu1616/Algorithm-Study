import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solution();
    }

    public void solution() {
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        List<Integer> locations = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            locations.add(scanner.nextInt());
        }

        locations.sort(Comparator.comparingInt(value -> value));
        int result = 0;
        int lastTapingStart = 0;
        int lastTapingEnd = 0;
        for (int location : locations) {
            if (lastTapingStart <= location && location <= lastTapingEnd) {
                continue;
            }
            lastTapingStart = location;
            lastTapingEnd = location + l - 1;
            result++;
        }

        System.out.println(result);
    }
}
