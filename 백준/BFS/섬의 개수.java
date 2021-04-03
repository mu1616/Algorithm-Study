import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static Scanner scan = new Scanner(System.in);
    int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Main main = new Main();
        while (true) {
            int w = scan.nextInt();
            int h = scan.nextInt();

            if (w == 0 && h == 0) {
                break;
            }
            main.solution(w, h);
        }

    }

    public void solution(int w, int h) {
        int graph[][] = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                graph[i][j] = scan.nextInt();
            }
        }

        boolean visited[][] = new boolean[h][w];
        int count = 0;
        for (int i = 0;  i< h; i++) {
            for (int j = 0; j < w; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    bfs(graph, visited, j, i);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public void bfs(int graph[][], boolean visited[][], int x, int y) {
        visited[y][x] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx >= 0 && nx < graph[0].length && ny >= 0 && ny < graph.length) {
                    if (!visited[ny][nx] && graph[ny][nx] == 1) {
                        queue.add(new Node(nx, ny));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }

    class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
