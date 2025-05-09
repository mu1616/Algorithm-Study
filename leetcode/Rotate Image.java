class Solution {
    public void rotate(int[][] matrix) {
        int row = 0;
        int col= 0;
        int count = 0;
        for (int i = matrix.length; i >= 2; i = i - 2) {
            move(matrix, row + count, col + count, i);
            count++;
        }
    }

    public void move(int[][] matrix, int row, int col, int length) {
        for (int i = 0; i < length - 1; i++) {
            int temp1 = matrix[row + i][col + length - 1];
            matrix[row + i][col + length - 1] = matrix[row][col + i];
            int temp2 = matrix[row + length - 1][col + length - i - 1];
            matrix[row + length - 1][col + length - i - 1] = temp1;
            temp1 = matrix[row + length - i - 1][col];
            matrix[row + length - i - 1][col] = temp2;
            matrix[row][col + i] = temp1;
        }
    }
}