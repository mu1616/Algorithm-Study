import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        char[][] board = Arrays.stream(wallpaper)
                .map(String::toCharArray)
                .toArray(char[][]::new);

        int lux = -1;
        int luy = -1;
        int rdx = -1;
        int rdy = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '#') {
                    luy = luy == -1 ? j : Math.min(luy, j);
                    lux = lux == -1 ? i : Math.min(lux, i);
                    rdy = rdy == -1 ? (j + 1) : Math.max(rdy, j + 1);
                    rdx = rdx == -1 ? (i + 1) : Math.max(rdx, i + 1);
                }
            }
        }

        return new int[] {lux, luy, rdx, rdy};
    }
}