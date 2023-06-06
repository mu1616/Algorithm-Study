import java.io.*;
import java.util.*;

public class Main {

    private final Scanner scanner = new Scanner(System.in);
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    private boolean visited[][];

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    public void solve() throws IOException {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int board[][] = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < k; i++) {
            board[scanner.nextInt() - 1][scanner.nextInt() - 1] = 1;
        }

        int result = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    result = Math.max(result, getBiggestTrashSize(board, i, j));
                }
            }
        }
        System.out.println(result);
    }

    public int getBiggestTrashSize(int board[][], int startRow, int startCol) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startRow, startCol));
        visited[startRow][startCol] = true;

        int size = 1;
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = currentNode.getRow() + dy[i];
                int nextCol = currentNode.getCol() + dx[i];
                if (nextRow < 0 || nextRow >= board.length || nextCol < 0 || nextCol >= board[0].length) {
                    continue;
                }
                if (board[nextRow][nextCol] == 0 || visited[nextRow][nextCol]) {
                    continue;
                }
                size++;
                visited[nextRow][nextCol] = true;
                queue.add(new Node(nextRow, nextCol));
            }
        }
        return size;
    }

    public static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return this.row;
        }

        public int getCol() {
            return this.col;
        }
    }
}