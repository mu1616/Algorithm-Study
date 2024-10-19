class Solution {
    
    int max = 0;
    public int solution(int k, int[][] dungeons) {
        max = 0;
        for (int i = 0; i < dungeons.length; i++) {
            dfs(k, 0, i, new boolean[dungeons.length], dungeons);
        }
        return max;
    }

    public void dfs(int hp, int cnt, int dungeon, boolean[] visited, int[][] dungeons) {
        visited[dungeon] = true;
        if (dungeons[dungeon][0] <= hp) {
            cnt++;
            max = Math.max(max, cnt);
            hp = hp - dungeons[dungeon][1];
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) {
                    dfs(hp, cnt, i, visited, dungeons);
                }
            }
        }
        visited[dungeon] = false;
    }
}