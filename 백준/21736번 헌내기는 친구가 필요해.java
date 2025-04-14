import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private final Scanner scanner = new Scanner(System.in);
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

    public static void main(String[] args) {
        Main main = new Main();
        main.solution();
    }

    public void solution() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        char[][] campus = new char[n][m];
        Location startLocation = null;
        for (int i = 0; i < n; i++) {
            campus[i] = scanner.next().toCharArray();
            for (int j = 0; j < m; j++) {
                if (campus[i][j] == 'I') {
                    startLocation = new Location(j, i);
                }
            }
        }

        Queue<Location> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.add(startLocation);
        visited[startLocation.y][startLocation.x] = true;

        int answer = 0;
        while (!queue.isEmpty()) {
            Location currentLocation = queue.poll();
            if (campus[currentLocation.y][currentLocation.x] == 'P') {
                answer++;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = currentLocation.x + DX[i];
                int nextY = currentLocation.y + DY[i];
                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || visited[nextY][nextX] || campus[nextY][nextX] == 'X') {
                    continue;
                }
                queue.offer(new Location(nextX, nextY));
                visited[nextY][nextX] = true;
            }
        }
        System.out.println(answer == 0 ? "TT" : answer);
    }

    public static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}