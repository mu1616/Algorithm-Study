import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private Scanner scanner = new Scanner(System.in);
    private List<List<Integer>> graph = new ArrayList<>();
    boolean visited[];
    int answer[];
    int cnt = 1;

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int r = scanner.nextInt();
        initVariables(n, m);
        dfs(r);
        System.out.println(Arrays.stream(answer)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("\n")));
    }
    
    public void initVariables(int n, int m) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            graph.get(vertex1 - 1).add(vertex2);
            graph.get(vertex2 - 1).add(vertex1);
        }
        graph.forEach(Collections::sort);
        visited = new boolean[n];
        answer = new int[n];
    }

    public void dfs(int r) {
        visited[r - 1] = true;
        answer[r - 1] = cnt;
        cnt++;
        for (int i : graph.get(r - 1)) {
            if (!visited[i - 1]) {
                dfs(i);
            }
        }
    }
}