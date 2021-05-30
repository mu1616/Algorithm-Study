import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static Scanner scan = new Scanner(System.in);
    int parent[];
    List<Integer> graph[];

    public static void main(String[] args) {
        Main main = new Main();
        main.solution();
    }

    public void solution() {
        int n = scan.nextInt();
        parent = new int[n];
        graph = new ArrayList[n];
        IntStream.range(0, n).forEach(i -> graph[i] = new ArrayList<>());
        IntStream.range(0, n - 1).forEach(i -> {
            int node1 = scan.nextInt() - 1;
            int node2 = scan.nextInt() - 1;
            graph[node1].add(node2);
            graph[node2].add(node1);
        });

        bfs();

        for (int i = 1; i < parent.length; i++) {
            System.out.println(parent[i] + 1);
        }
    }

    public void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 0; i < graph[node].size(); i++) {
                int nextNode = graph[node].get(i);
                if (!visited[nextNode]) {
                    queue.add(nextNode);
                    visited[nextNode] = true;
                    parent[nextNode] = node;
                }
            }
        }
    }
}
