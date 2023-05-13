import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private final Scanner scanner = new Scanner(System.in);
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    int[] dist;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int x = scanner.nextInt();
        dist = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i = 0; i < m; i++) {
            graph.get(scanner.nextInt()).add(scanner.nextInt());
        }
        bfs(x);
        printAnswer(k);
    }

    public void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        boolean[] visited = new boolean[graph.size()];
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int nextNode: graph.get(currentNode)) {
                if (visited[nextNode]) {
                    continue;
                }
                queue.add(nextNode);
                visited[nextNode] = true;
                dist[nextNode] = dist[currentNode] + 1;
            }
        }
    }

    public void printAnswer(int k) {
        List<Integer> answerNodes = new ArrayList<>();
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == k) {
                answerNodes.add(i);
            }
        }
        if (answerNodes.isEmpty()) {
            System.out.println("-1");
            return;
        }
        System.out.println(answerNodes.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("\n")));
    }
}