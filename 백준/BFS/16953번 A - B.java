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
        long a = scanner.nextLong();
        long b= scanner.nextLong();
        System.out.println(bfs(a, b));
    }

    public int bfs(long a, long b) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a, 1));

        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode.num == b) {
                return currentNode.count;
            }
            if (currentNode.num > b) {
                continue;
            }
            queue.add(new Node(currentNode.num * 2, currentNode.count + 1));
            queue.add(new Node(currentNode.num * 10 + 1, currentNode.count + 1));
        }

        return -1;
    }

    public class Node {
        long num;
        int count;

        public Node(long num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}