import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private int n;
    private int m;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        n = scanner.nextInt();
        m = scanner.nextInt();
        recursion(Collections.emptyList());
    }

    public void recursion(List<Integer> list) {
        if (list.size() == m) {
            String result = list.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));
            System.out.println(result);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!list.contains(i)) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(i);
                recursion(newList);
            }
        }
    }
}