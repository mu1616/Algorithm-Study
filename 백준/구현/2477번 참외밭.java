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
        int k = scanner.nextInt();
        List<Point> points = new ArrayList<>();
        int x = 0;
        int y = 0;
        for (int i = 0; i < 6; i++) {
            int d = scanner.nextInt();
            int length = scanner.nextInt();
            if (d == 1) {
                x = x + length;
            }
            if (d == 2) {
                x = x - length;
            }
            if (d == 3) {
                y = y - length;
            }
            if (d == 4) {
                y = y + length;
            }
            points.add(new Point(x, y));
        }
        points.sort(Comparator.comparingInt((Point point) -> point.x).thenComparingInt(point -> -point.y));
        int area1 = (points.get(0).y - points.get(1).y) * (points.get(2).x - points.get(0).x);
        int area2 = (points.get(4).y - points.get(5).y) * (points.get(5).x - points.get(2).x);
        int result = (area1 + area2) * k;
        System.out.println(result);
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}