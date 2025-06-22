class Solution {

    public static final int[] DX = {0, 0, 1, -1};
    public static final int[] DY = {-1, 1, 0, 0};

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    bfs(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(int startRow, int startCol, char[][] grid, boolean[][] visited) {
        Queue<Value> queue = new LinkedList<>();
        queue.add(new Value(startRow, startCol));
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            Value value = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = value.row + DY[i];
                int nextCol = value.col + DX[i];

                if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length || visited[nextRow][nextCol] || grid[nextRow][nextCol] == '0') {
                    continue;
                }
                queue.add(new Value(nextRow, nextCol));
                visited[nextRow][nextCol] = true;
            }
        }
    }

    public static class Value {
        int row;
        int col;

        public Value(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}