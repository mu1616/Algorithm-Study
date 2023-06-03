import java.io.*;
import java.util.*;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int [][]height = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                height[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i <= 256; i++) {
            int result = calc(height, i, b);
            if (result != -1) {
                resultMap.put(i, result);
            }
        }

        Comparator<Map.Entry<Integer, Integer>> comparator = Comparator.comparingInt((Map.Entry<Integer, Integer> e) -> e.getValue())
                .thenComparing((e1, e2) -> e2.getKey() - e1.getKey());

        Map.Entry<Integer, Integer> result = resultMap.entrySet()
                .stream()
                .min(comparator)
                .orElseThrow();

        System.out.println(result.getValue() + " " + result.getKey());
    }

    public int calc(int[][] height, int targetHeight, int blocks) {
        int time = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height[0].length; j++) {
                if (height[i][j] > targetHeight) {
                    time = time + (2 * (height[i][j] - targetHeight));
                    blocks = blocks + (height[i][j] - targetHeight);
                    continue;
                }
                if (height[i][j] < targetHeight) {
                    time = time + (targetHeight - height[i][j]);
                    blocks = blocks - (targetHeight - height[i][j]);
                }
            }
        }
        if (blocks < 0) {
            return -1;
        }
        return time;
    }
}