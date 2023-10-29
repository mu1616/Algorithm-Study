import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    public void solve() throws IOException {
        Deque<Character> deque = new ArrayDeque<>();
        Stack<Integer> commandStack = new Stack<>();
        int n = scanner.nextInt();
        for (int i = 0 ; i< n; i++) {
            int command = scanner.nextInt();
            if (command == 1) {
                deque.addLast(scanner.next().charAt(0));
                commandStack.push(1);
                continue;
            }
            if (command == 2) {
                deque.addFirst(scanner.next().charAt(0));
                commandStack.push(2);
                continue;
            }
            if (command == 3) {
                if (commandStack.isEmpty()) {
                    continue;
                }
                int lastCommand = commandStack.pop();
                if (lastCommand == 1) {
                    deque.removeLast();
                    continue;
                }
                if (lastCommand == 2) {
                    deque.removeFirst();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : deque) {
            sb.append(c);
        }
        System.out.println(sb.toString().length() == 0 ? "0" : sb);
    }
}