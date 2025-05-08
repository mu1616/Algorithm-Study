class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int i = 0;
        int j = 0;
        int d = 0;
        List<Integer> result = new ArrayList<>();
        while (result.size() < matrix.length * matrix[0].length) {
            visited[i][j] = true;
            result.add(matrix[i][j]);

            int nextI = i + dy[d];
            int nextJ = j + dx[d];

            if (nextI < 0 || nextI >= matrix.length || nextJ < 0 || nextJ >= matrix[0].length || visited[nextI][nextJ]) {
                d = (d + 1) % 4;
                i = i + dy[d];
                j = j + dx[d];
            } else {
                i = nextI;
                j = nextJ;
            }
        }
        return result;
    }
}