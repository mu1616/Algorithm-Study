import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solution();
    }

    public void solution() {
        Board board = Board.create();

        int result = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                result++;
                int num = scanner.nextInt();
                board.mark(num);
                if (board.isBingo()) {
                    System.out.println(result);
                    return;
                }
            }
        }
    }

    static class Board {
        private Point[][] points;

        private Board(Point[][] points) {
            this.points = points;
        }

        public static Board create() {
            Point[][] points = new Point[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    points[i][j] = new Point(scanner.nextInt(), false);
                }
            }
            return new Board(points);
        }

        public Point getPoint(int row, int col) {
            return points[row][col];
        }

        public void mark(int num) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    Point point = getPoint(i, j);
                    if (point.getNum() == num) {
                        point.mark();
                        return;
                    }
                }
            }
        }

        public boolean isBingo() {
            int lineClearCnt = 0;

            // 가로 체크
            for (int i = 0; i < 5; i++) {
                if (isRowLineClear(i)) {
                    lineClearCnt++;
                }
            }

            // 세로 체크
            for (int i = 0; i < 5; i++) {
                if (isColLineClear(i)) {
                    lineClearCnt++;
                }
            }

            // 오른쪽 밑으로 내려가는 대각선 체크
            boolean isLineClear = true;
            for (int i = 0; i < 5; i++) {
                if (!getPoint(i, i).isMarked()) {
                    isLineClear = false;
                    break;
                }
            }
            lineClearCnt = isLineClear ? lineClearCnt + 1 : lineClearCnt;

            // 오른쪽 위로 올라가는 대각선 체크
            isLineClear = true;
            for (int i = 0; i < 5; i++) {
                if (!getPoint(4 - i, i).isMarked()) {
                    isLineClear = false;
                    continue;
                }
            }
            lineClearCnt = isLineClear ? lineClearCnt + 1 : lineClearCnt;

            return lineClearCnt >= 3;
        }

        public boolean isRowLineClear(int row) {
            for (int i = 0; i < 5; i++) {
                if (!getPoint(row, i).isMarked()) {
                    return false;
                }
            }
            return true;
        }

        public boolean isColLineClear(int col) {
            for (int i = 0; i < 5; i++) {
                if (!getPoint(i, col).isMarked()) {
                    return false;
                }
            }
            return true;
        }
    }

    static class Point {
        private int num;
        private boolean marked;

        public Point(int num, boolean marked) {
            this.num = num;
            this.marked = marked;
        }

        public void mark() {
            this.marked = true;
        }

        public int getNum() {
            return this.num;
        }

        public boolean isMarked() {
            return this.marked;
        }
    }
}
