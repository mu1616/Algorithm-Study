import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private final Scanner scanner = new Scanner(System.in);
    private Map<Integer, List<Integer>> graph = new HashMap<>();
    private Map<Integer, Integer> result = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            dfs(i, i, new boolean[n + 1]);
        }

        System.out.println(getAnswer());
    }

    public void dfs(int startNode, int currentNode, boolean[] visited) {
        visited[currentNode] = true;
        result.put(startNode, result.getOrDefault(startNode, 0) + 1);

        for (int nextNode : graph.get(currentNode)) {
            if (!visited[nextNode]) {
                dfs(startNode, nextNode, visited);
            }
        }
    }

    private String getAnswer() {
        int max = Collections.max(result.values());
        List<Integer> answerNodes = new ArrayList<>();
        for (int node : result.keySet()) {
            if (result.get(node) == max) {
                answerNodes.add(node);
            }
        }
        return answerNodes.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}