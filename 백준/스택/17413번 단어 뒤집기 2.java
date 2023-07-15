
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
        String str = scanner.nextLine();
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        boolean isTag = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '<') {
                while (!stack.isEmpty()) {
                    queue.add(stack.pop());
                }
                isTag = true;
                queue.add(c);
                continue;
            }
            if (c == '>') {
                queue.add(c);
                isTag = false;
                continue;
            }
            if (c == ' ') {
                while (!stack.isEmpty()) {
                    queue.add(stack.pop());
                }
                queue.add(c);
                continue;
            }
            if (isTag) {
                queue.add(c);
                continue;
            }
            stack.push(c);
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        while(!queue.isEmpty()) {
            System.out.print(queue.poll());
        }
    }
}