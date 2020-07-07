import java.util.*;

class Solution {
    boolean visited[][];
    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};
    int picture[][];

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        this.picture = picture;
        visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n ; j++) {
                if(picture[i][j] != 0 && !visited[i][j]) {
                    numberOfArea++;
                    int sum = bfs(j, i);

                    if(maxSizeOfOneArea < sum)
                        maxSizeOfOneArea = sum;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public int bfs(int x, int y) {
        int sum = 1;
        Queue<Node> queue = new LinkedList<>();
        visited[y][x] = true;
        queue.offer(new Node(x, y));

        while(!queue.isEmpty()) {
            Node curr = queue.poll();

            for(int next = 0; next < 4; next++) {
                int nx = curr.x + dx[next];
                int ny = curr.y + dy[next];

                if(nx >=0 && nx < picture[0].length && ny >=0 && ny < picture.length) {
                    if(!visited[ny][nx] && picture[curr.y][curr.x] == picture[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.offer(new Node(nx, ny));
                        sum++;
                    }
                }
            }
        }

        return sum;
    }

    class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}