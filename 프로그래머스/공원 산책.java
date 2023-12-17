import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int currentRow = 0;
        int currentCol = 0;
        char[][] board = new char[park.length][park[0].length()];
        for (int i = 0; i < park.length; i++) {
            board[i] = park[i].toCharArray();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'S') {
                    currentRow = i;
                    currentCol = j;
                }
            }
        }

        for (int i = 0; i < routes.length; i++) {
            String route = routes[i];
            String[] split = route.split(" ");
            String dir = split[0];
            int cnt = Integer.parseInt(split[1]);

            if (dir.equals("W")) {
                int nextCol = currentCol - cnt;
                int finalCurrentRow = currentRow;
                int[][] locations = IntStream.range(nextCol, currentCol + 1)
                        .mapToObj(col -> new int[]{finalCurrentRow, col})
                        .toArray(int[][]::new);

                if (nextCol >= 0 && !containsX(board, locations)) {
                    currentCol = nextCol;
                }
                continue;
            }
            if (dir.equals("E")) {
                int nextCol = currentCol + cnt;
                int finalCurrentRow = currentRow;
                int[][] locations = IntStream.range(currentCol, nextCol + 1)
                        .mapToObj(col -> new int[]{finalCurrentRow, col})
                        .toArray(int[][]::new);

                if (nextCol < board[0].length && !containsX(board, locations)) {
                    currentCol = nextCol;
                }
                continue;
            }
            if (dir.equals("N")) {
                int nextRow = currentRow - cnt;
                int finalCurrentCol = currentCol;
                int[][] locations = IntStream.range(nextRow, currentRow + 1)
                        .mapToObj(row -> new int[]{row, finalCurrentCol})
                        .toArray(int[][]::new);

                if (nextRow >= 0 && !containsX(board, locations)) {
                    currentRow = nextRow;
                }
                continue;
            }
            if (dir.equals("S")) {
                int nextRow = currentRow + cnt;
                int finalCurrentCol = currentCol;
                int[][] locations = IntStream.range(currentRow, nextRow + 1)
                        .mapToObj(row -> new int[]{row, finalCurrentCol})
                        .toArray(int[][]::new);
                if (nextRow < board.length && !containsX(board, locations)) {
                    currentRow = nextRow;
                }
            }
        }

        return new int[]{currentRow, currentCol};
    }

    private boolean containsX(char[][] board, int[][] locations) {
        for (int i = 0; i < locations.length; i++) {
            int row = locations[i][0];
            int col = locations[i][1];
            if (board[row][col] == 'X') {
                return true;
            }
        }
        return false;
    }
}