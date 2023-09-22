import java.util.*;

public class Main {

    private final Scanner scanner = new Scanner(System.in);
    int x;
    int answer = Integer.MAX_VALUE;
    boolean hasAnswer = false;

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        x = scanner.nextInt();
        char[] arr = String.valueOf(x).toCharArray();
        permutation(arr, 0, arr.length);
        if (hasAnswer) {
            System.out.println(answer);
        } else {
            System.out.println("0");
        }
    }

    public void permutation(char[] arr, int start, int r) {
        if (start > 0 && arr[0] == 0) {
            return;
        }

        String num = "";
        for (int i = 0; i <= start - 1; i++) {
            num = num + arr[i];
        }
        if (!num.equals("") && Integer.parseInt(num) < Integer.parseInt(String.valueOf(x).substring(0, start))) {
            return;
        }
        if (r == 0) {
            if (Integer.parseInt(new String(arr)) > x) {
                answer = Math.min(answer, Integer.parseInt(new String(arr)));
                hasAnswer = true;
            }
            return;
        }
        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            permutation(arr, start + 1, r - 1);
            swap(arr, start, i);
        }
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
