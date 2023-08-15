import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private final Scanner scanner = new Scanner(System.in);
    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};

    int paper[][];
    boolean visited[][];

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    public void solve() throws IOException {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        paper = createPaper(n, m);
        visited = new boolean[n][m];

        int maxPictureSize = 0;
        int pictureCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && paper[i][j] == 1) {
                    pictureCount++;
                    maxPictureSize = Math.max(maxPictureSize, getPictureSize(i, j));
                }
            }
        }
        System.out.println(pictureCount);
        System.out.println(maxPictureSize);
    }

    public int[][] createPaper(int n, int m) {
        int paper[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                paper[i][j] = scanner.nextInt();
            }
        }
        return paper;
    }

    public int getPictureSize(int startRow, int startCol) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startRow, startCol));
        visited[startRow][startCol] = true;

        int pictureSize = 1;
        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = currentPoint.row + dy[i];
                int nextCol = currentPoint.col + dx[i];

                if (nextRow >= 0 && nextRow < paper.length && nextCol >= 0 && nextCol < paper[0].length && !visited[nextRow][nextCol] && paper[nextRow][nextCol] == 1) {
                    queue.add(new Point(nextRow, nextCol));
                    visited[nextRow][nextCol] = true;
                    pictureSize++;
                }
            }
        }
        return pictureSize;
    }

    public static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}