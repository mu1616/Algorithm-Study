import java.util.*;

public class Main {

    private final Scanner scanner = new Scanner(System.in);
    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        Character[][] board = new Character[12][6];
        for (int i = 0; i < 12; i++) {
            String line = scanner.nextLine();
            int j = 0;
            for (char c : line.toCharArray()) {
                board[i][j] = c;
                j++;
            }
        }

        int result = 0;
        while (true) {
            boolean[][] visited = new boolean[12][6];
            boolean modify = false;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (visited[i][j] || board[i][j] == '.') {
                        continue;
                    }
                    board = bfs(board, visited, i, j);
                    if (board[i][j] == '.') {
                        modify = true;
                    }
                }
            }
            if (modify) {
                result++;
            } else {
                break;
            }
            down(board);

        }
        System.out.println(result);
    }

    public Character[][] bfs(Character[][] board, boolean[][] visited, int row, int col) {
        Character[][] refreshedBoard = getCopyBoard(board);
        if (board[row][col] == '.') {
            return refreshedBoard;
        }
        int linkCnt = 1;
        Queue<Value> queue = new LinkedList<>();
        queue.add(new Value(board[row][col], row, col));
        visited[row][col] = true;
        refreshedBoard[row][col] = '.';

        while (!queue.isEmpty()) {
            Value currentValue = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = currentValue.row + dy[i];
                int nextCol = currentValue.col + dx[i];
                if (nextRow < 0 || nextRow > 11 || nextCol < 0 || nextCol > 5 || visited[nextRow][nextCol]) {
                    continue;
                }
                if (board[nextRow][nextCol] == currentValue.color) {
                    linkCnt++;
                    refreshedBoard[nextRow][nextCol] = '.';
                    visited[nextRow][nextCol] = true;
                    queue.add(new Value(currentValue.color, nextRow, nextCol));
                }
            }
        }
        return linkCnt >= 4 ? refreshedBoard : board;
    }

    public Character[][] getCopyBoard(Character[][] board) {
        Character[][] copy = new Character[12][6];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }

    public void down(Character[][] board) {
        for (int i = 0; i < 6; i++) {
            for (int j = 10; j >= 0; j--) {
                if (board[j][i] == '.') {
                    continue;
                }
                for (int k = 11; k > j; k--) {
                    if (board[k][i] == '.') {
                        board[k][i] = board[j][i];
                        board[j][i] = '.';
                        break;
                    }
                }
            }
        }
    }

    public class Value {
        char color;
        int row;
        int col;

        public Value(char color, int row, int col) {
            this.color = color;
            this.row = row;
            this.col = col;
        }
    }
}
