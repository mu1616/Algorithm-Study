import java.util.*;

public class Main {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        String s = scanner.nextLine();
        List<String> suffixList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            suffixList.add(s.substring(i));
        }
        suffixList.stream()
                .sorted()
                .forEach(System.out::println);

    }
}