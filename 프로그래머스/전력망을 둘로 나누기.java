import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for (int cutIndex = 0; cutIndex < wires.length; cutIndex++) {
            int[][] graph = createGraph(n, wires, cutIndex);
            int count1 = calcTowerCount(graph, wires[cutIndex][0]);
            int count2 = calcTowerCount(graph, wires[cutIndex][1]);
            int diff = Math.abs(count1 - count2);
            answer = Math.min(answer, diff);
        }
        return answer;
    }

    public int calcTowerCount(int[][] graph, int startNum) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNum);
        visited[startNum] = true;

        int result = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 0; i < graph.length; i++) {
                if (!visited[i] && graph[node][i] == 1) {
                    result++;
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return result;
    }

    public int[][] createGraph(int n, int[][] wires, int cutIndex) {
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < wires.length; i++) {
            if (i == cutIndex) {
                continue;
            }
            graph[wires[i][0]][wires[i][1]] = 1;
            graph[wires[i][1]][wires[i][0]] = 1;
        }
        return graph;
    }
}