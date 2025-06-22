class Solution {

    public static final int[] DX = {0, 0, 1, -1};
    public static final int[] DY = {-1, 1, 0, 0};

    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    bfs(i, j, board, visited);
                }
            }
        }
    }

    public void bfs(int startRow, int startCol, char[][] board, boolean[][] visited) {
        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(startRow, startCol));
        visited[startRow][startCol] = true;
        List<Location> locations = new ArrayList<>();
        locations.add(new Location(startRow, startCol));

        boolean surround = true;
        while(!queue.isEmpty()) {
            Location location = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = location.row + DY[i];
                int nextCol = location.col + DX[i];

                if (visited[nextRow][nextCol] || board[nextRow][nextCol] == 'X') {
                    continue;
                }
                if (nextRow == 0 || nextRow == board.length - 1 || nextCol == 0 || nextCol == board[0].length - 1) {
                    surround = false;
                    visited[nextRow][nextCol] = true;
                    continue;
                }
                queue.add(new Location(nextRow, nextCol));
                visited[nextRow][nextCol] = true;
                locations.add(new Location(nextRow, nextCol));
            }
        }
        if (surround) {
            for (Location location : locations) {
                board[location.row][location.col] = 'X';
            }
        }
    }

    public static class Location {
        int row;
        int col;

        public Location(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}