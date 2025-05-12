class Solution {
    public static int ZERO_TO_ZERO = 3;
    public static int ZERO_TO_ONE = 4;
    public static int ONE_TO_ONE = 5;
    public static int ONE_TO_ZERO = 6;

    public static int[] DX = {-1 , 0, 1, -1, 1, -1, 0, 1};
    public static int[] DY = {-1, -1, -1, 0, 0, 1, 1, 1};

    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                setValue(board, i, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == ZERO_TO_ZERO || board[i][j] == ONE_TO_ZERO) {
                    board[i][j] = 0;
                } else {
                    board[i][j] = 1;
                }
            }
        }
    }

    public void setValue(int[][] board, int row, int col) {
        int currentValue = board[row][col];

        int oneCount = 0;
        for (int i = 0; i < 8; i++) {
            int targetRow = row + DY[i];
            int targetCol = col + DX[i];
            if (targetRow < 0 || targetRow >= board.length || targetCol < 0 || targetCol >= board[0].length) {
                continue;
            }
            if (board[targetRow][targetCol] == 1 || board[targetRow][targetCol] == ONE_TO_ONE || board[targetRow][targetCol] == ONE_TO_ZERO) {
                oneCount++;
            }
        }

        if (isOriginOne(currentValue)) {
            if (oneCount < 2) {
                board[row][col] = ONE_TO_ZERO;
                return;
            }
            if (oneCount < 4) {
                board[row][col] = ONE_TO_ONE;
                return;
            }
            board[row][col] = ONE_TO_ZERO;
            return;
        }
        board[row][col] = oneCount == 3 ? ZERO_TO_ONE : ZERO_TO_ZERO;
    }

    public boolean isOriginOne(int value) {
        return value == 1 || value == ONE_TO_ONE || value == ONE_TO_ZERO;
    }
}