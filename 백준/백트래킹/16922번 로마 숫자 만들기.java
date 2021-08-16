import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);
    int[] numbers = new int[80];
    HashSet<Integer> set = new HashSet<>();
    int answer = 0;
    int n = 0;
    Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.solution();
    }

    public void solution() {
        n = scan.nextInt();
        init();
        combi(numbers, 0, n);

        System.out.println(answer);
    }

    public void combi(int arr[], int start, int r) {
        if (r == 0) {
            int sum = stack.stream().mapToInt(i -> i).sum();
            if (!set.contains(sum)) {
                answer++;
                set.add(sum);
            }
            return;
        }
        int currentPop = -1;
        for (int i = start; i < arr.length; i++) {
            if (currentPop != arr[i]) {
                stack.push(arr[i]);
                combi(arr, i + 1, r - 1);
                currentPop = stack.pop();
            }
        }
    }

    public void init() {
        for (int i = 0; i < 20; i++) {
            numbers[i] = 1;
        }
        for (int i = 20; i < 40; i++) {
            numbers[i] = 5;
        }
        for (int i = 40; i < 60; i++) {
            numbers[i] = 10;
        }
        for (int i = 60; i < 80; i++) {
            numbers[i] = 50;
        }
    }
}
