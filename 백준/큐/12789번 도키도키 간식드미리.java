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
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        IntStream.range(0, n).forEach(i -> queue.offer(scan.nextInt()));

        int possibleIndex = 1;
        while(!queue.isEmpty()) {
            int index1 = queue.poll();

            if (possibleIndex == index1) {
                possibleIndex++;
            } else {
                stack.push(index1);
            }

            while(!stack.isEmpty()) {
                int index2 = stack.peek();

                if (possibleIndex == index2) {
                    possibleIndex++;
                    stack.pop();
                } else {
                    break;
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}
