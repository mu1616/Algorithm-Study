import java.util.*;

public class Main {

    private final Scanner scanner = new Scanner(System.in);
    Map<Integer, Integer> moveMap = new HashMap<>();
    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            moveMap.put(x, y);
        }
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            moveMap.put(u, v);
        }
        System.out.println(bfs());
    }

    public int bfs() {
        Queue<Value> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];
        visited[1] = true;
        queue.add(new Value(1, 0));

        while (!queue.isEmpty()) {
            Value currentValue = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int nextLocation = currentValue.location + i;
                if (visited[nextLocation]) {
                    continue;
                }
                if (moveMap.containsKey(nextLocation)) {
                    nextLocation = moveMap.get(nextLocation);
                    if (visited[nextLocation]) {
                        continue;
                    }
                }
                if (nextLocation == 100) {
                    return currentValue.count + 1;
                }
                queue.add(new Value(nextLocation, currentValue.count + 1));
                visited[nextLocation] = true;
            }
        }
        throw new IllegalStateException();
    }

    public static class Value {
        int location;
        int count;

        public Value(int location, int count) {
            this.location = location;
            this.count = count;
        }
    }
}
