import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    public void solve() throws IOException {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int dist[] = dijkstra(n, k);
        System.out.println(dist[k]);
    }

    public int[] dijkstra(int n, int k) {
        int[] dist = new int[100001];
        dist[n] = 0;
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.time));
        pq.offer(new Point(n, 0));
        dist[n] = 0;

        while(!pq.isEmpty()) {
            Point currentPoint = pq.poll();

            Point nextPoint1 = new Point(currentPoint.location - 1, currentPoint.time + 1);
            Point nextPoint2 = new Point(currentPoint.location + 1, currentPoint.time + 1);
            Point nextPoint3 = new Point(currentPoint.location * 2, currentPoint.time);

            if (nextPoint1.location >= 0 && dist[nextPoint1.location] > nextPoint1.time) {
                dist[nextPoint1.location] = nextPoint1.time;
                pq.offer(nextPoint1);
            }
            if (nextPoint2.location <= 100000 && dist[nextPoint2.location] > nextPoint2.time) {
                dist[nextPoint2.location] = nextPoint2.time;
                pq.offer(nextPoint2);
            }
            if (nextPoint3.location <= 100000 && dist[nextPoint3.location] > nextPoint3.time) {
                dist[nextPoint3.location] = nextPoint3.time;
                pq.offer(nextPoint3);
            }
        }
        return dist;
    }

    public static class Point {
        int location;
        int time;

        public Point(int location, int time) {
            this.location = location;
            this.time = time;
        }
    }
}