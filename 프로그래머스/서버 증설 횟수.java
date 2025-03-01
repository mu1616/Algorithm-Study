import java.util.*;

class Solution {
    
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Server> servers = new LinkedList<>();

        for (int i = 0; i < 24; i++) {
            int playerCount = players[i];
            int currentServerCount = servers.size();
            int requiredServerCount = playerCount / m;

            if (currentServerCount < requiredServerCount) {
                int addedServerCount = requiredServerCount - currentServerCount;
                for (int j = 0; j < addedServerCount; j++) {
                    servers.add(new Server(k));
                }
                answer = answer + addedServerCount;
            }
            for (Server server : servers) {
                server.minusOneHours();
            }
            while (!servers.isEmpty() && servers.peek().remainHours == 0) {
                servers.poll();
            }
        }
        return answer;
    }

    public static class Server {
        int remainHours;

        public Server(int remainHours) {
            this.remainHours = remainHours;
        }

        public void minusOneHours() {
            this.remainHours = this.remainHours - 1;
        }
    }
}