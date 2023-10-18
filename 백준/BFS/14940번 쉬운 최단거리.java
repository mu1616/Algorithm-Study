import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private final Scanner scanner = new Scanner(System.in);
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int targetRow = 0;
        int targetCol = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    targetRow = i;
                    targetCol = j;
                }
            }
        }
        int[][] result = bfs(map, targetRow, targetCol);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public int[][] bfs(int[][] map, int targetRow, int targetCol) {
        int[][] result = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                result[i][j] = -1;
            }
        }

        Queue<Value> queue = new LinkedList<>();
        queue.add(new Value(targetRow, targetCol, 0));
        result[targetRow][targetCol] = 0;

        while (!queue.isEmpty()) {
            Value currentValue = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = currentValue.row + dy[i];
                int nextCol = currentValue.col + dx[i];

                if (nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map[0].length) {
                    continue;
                }
                if (result[nextRow][nextCol] != -1) {
                    continue;
                }
                if (map[nextRow][nextCol] == 1) {
                    result[nextRow][nextCol] = currentValue.distance + 1;
                    queue.add(new Value(nextRow, nextCol, currentValue.distance + 1));
                }
                if (map[nextRow][nextCol] == 0) {
                    result[nextRow][nextCol] = 0;
                }
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    result[i][j] = 0;
                }
            }
        }
        return result;
    }

    class Value {
        int row;
        int col;
        int distance;

        public Value(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
}
