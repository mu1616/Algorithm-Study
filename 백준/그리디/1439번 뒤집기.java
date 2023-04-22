import java.util.Scanner;

public class Main {

    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        String s = scanner.next();
        System.out.println(Math.min(getCount(s, 1), getCount(s, 0)));
    }

    public int getCount(String s, int targetNum) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentNum = Integer.parseInt(s.substring(i, i + 1));
            if (i == 0) {
                count = currentNum == targetNum ? count + 1 : count;
                continue;
            }
            int beforeNum = Integer.parseInt(s.substring(i - 1, i));
            if (currentNum == targetNum && currentNum != beforeNum) {
                count++;
            }
        }
        return count;
    }

}
