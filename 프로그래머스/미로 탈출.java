import java.util.*;

class Solution {
    
    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, 1, -1, 0};

        public int solution(String[] maps) {
        int startX = 0;
        int startY = 0;
        int leverX = 0;
        int leverY = 0;
        char[][] maze = new char[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            maze[i] = maps[i].toCharArray();
            for (int j = 0; j < maps[0].length(); j++) {
                if (maze[i][j] == 'S') {
                    startX = j;
                    startY = i;
                }
                if (maze[i][j] == 'L') {
                    leverX = j;
                    leverY = i;
                }
            }
        }

        int count1 = bfs(startX, startY, maze, 'L');
        if (count1 == -1) {
            return -1;
        }
        int count2 = bfs(leverX, leverY, maze, 'E');
        if (count2 == -1) {
            return -1;
        }
        return count1 + count2;
    }

    public int bfs(int currentX, int currentY, char[][] maze, char target) {
        Queue<Location> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[currentY][currentX] = true;
        queue.add(new Location(currentX, currentY, 0));

        while (!queue.isEmpty()) {
            Location currentLocation = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = currentLocation.x + dx[i];
                int nextY = currentLocation.y + dy[i];
                if (nextX < 0 || nextX >= maze[0].length || nextY < 0 || nextY >= maze.length || visited[nextY][nextX] || maze[nextY][nextX] == 'X') {
                    continue;
                }
                if (maze[nextY][nextX] == target) {
                    return currentLocation.count + 1;
                }
                queue.add(new Location(nextX, nextY, currentLocation.count + 1));
                visited[nextY][nextX] = true;
            }
        }
        return -1;
    }

    public static class Location {
        int x;
        int y;
        int count;

        public Location(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}