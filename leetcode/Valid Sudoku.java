class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> set1 = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (set1.contains(c)) {
                    return false;
                }
                set1.add(c);
            }
            Set<Character> set2 = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (c == '.') {
                    continue;
                }
                if (set2.contains(c)) {
                    return false;
                }
                set2.add(c);
            }
        }

        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                if (!isValid3x3(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid3x3(char[][] board, int i, int j) {
        Set<Character> set = new HashSet<>();
        for (int k = 0; k < 3; k++) {
            for(int l = 0; l < 3; l++) {
                char c = board[i + k][j + l];
                if (c == '.') {
                    continue;
                }
                if (set.contains(c)) {
                    return false;
                }
                set.add(c);
            }
        }
        return true;
    }
}