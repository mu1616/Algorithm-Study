class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int[] walls = new int[n + 1];
        for (int i = 0; i < section.length; i++) {
            walls[section[i]] = 1;
        }
        int cursor = 0;
        while (cursor < walls.length) {
            if (walls[cursor] == 1) {
                answer++;
                cursor = cursor + m;
            } else {
                cursor++;
            }
        }
        return answer;
    }
}