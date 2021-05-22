import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solution();
    }

    public void solution() {
        int n = scan.nextInt();
        int m = scan.nextInt();
        int [] lessons  = IntStream.range(0,n).map(i -> scan.nextInt()).toArray();

        int lessonsSum = Arrays.stream(lessons).sum();
        int left = 0;
        int right = lessonsSum;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            int loc = lessons.length - 1;
            for (int i = 0; i < m; i++) {
                int sum = 0;
                while (loc >= 0) {
                    sum += lessons[loc];
                    if (sum > mid) {
                        break;
                    }
                    loc--;
                }
            }

            if (loc == -1) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
