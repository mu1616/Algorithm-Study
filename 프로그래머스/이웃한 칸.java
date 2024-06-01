class Solution {
    
    public int solution(String[][] board, int h, int w) {
        int count = 0;
        int[] dh = {-1, 1, 0, 0};
        int[] dw = {0, 0, 1, -1};
        for (int i = 0; i < 4; i++) {
            int currentH = h + dh[i];
            int currentW = w + dw[i];
            if (currentH >= 0 && currentH < board.length && currentW >= 0 && currentW < board.length && board[currentH][currentW].equals(board[h][w])) {
                count++;
            }
        }
        return count;
    }
}