import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solution();
    }

    public void solution() {
        int k = scan.nextInt();
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            int inputNumber = scan.nextInt();

            if (inputNumber == 0) {
                sum -= stack.pop();
            } else {
                stack.push(inputNumber);
                sum += inputNumber;
            }
        }

        System.out.println(sum);
    }
}
