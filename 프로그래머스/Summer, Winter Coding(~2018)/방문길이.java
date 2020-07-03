class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int graph[][] = new int[121][121];
        int nx = 5;
        int ny = 5;

        for(int i=0; i< dirs.length(); i++) {
            char a = dirs.charAt(i);
            int tmpX = nx;
            int tmpY = ny;
            if(a == 'L') {
                nx = nx - 1;

            } else if(a == 'U') {
                ny = ny - 1;

            } else if(a == 'D') {
                ny = ny + 1;

            } else if(a == 'R') {
                nx = nx + 1;

            }

            if(nx < 0 || nx >= 11) {
                nx = tmpX;
                continue;
            }

            if(ny < 0 || ny >= 11) {
                ny = tmpY;
                continue;
            }

            int cl = tmpY * 11 + tmpX;   //current location
            int nl = ny * 11 + nx;     // next location

            if(graph[cl][nl] == 0) {
                answer++;
                graph[cl][nl] = 1;
                graph[nl][cl] = 1;
            }
        }
        System.out.print(answer);
        return answer;
    }
}