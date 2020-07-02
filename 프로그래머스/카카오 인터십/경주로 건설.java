class Solution {
    int dx[] = {1, -1, 0, 0};
    int dy[] = {0, 0, 1, -1};
    int board[][];
    int result = Integer.MAX_VALUE;
    boolean visited[][];    
    int dist[][];

   public int solution(int[][] board) {
        int answer = 0;
        this.board = board;
        visited = new boolean[board.length][board[0].length];
        dist = new int[board.length][board.length];

        for(int i=0; i< dist.length; i++) {
            for(int j=0; j< dist.length; j++)
                dist[i][j] = Integer.MAX_VALUE;
        }

        dfs(0, 0, 0, 0, 0);

        answer = result;

        return answer;
    }

    public void dfs(int bx, int by, int x, int y, int sum) {
        visited[y][x] = true;
        dist[y][x] = sum;

        if(y == board.length -1 && x == board.length - 1) {
            if(result > sum)
                result = sum;

            visited[y][x] = false;

            return;
        }

        for(int i = 0; i< 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            if(cx >=0 && cx < board.length && cy >= 0 && cy < board.length && !visited[cy][cx]) {
                if(board[cy][cx] == 0) {
                    int price = sum + 100;

                    if(bx != cx && by != cy)
                        price += 500;

                    if(price <= dist[cy][cx]) {
                        dfs(x, y, cx, cy, price);
                    }
                }
            }
        }

        visited[y][x] = false;
    }
}