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
        int num = 1;
        while(true) {
            String str = scanner.nextLine();
            if (str.contains("-")) {
                break;
            }
            printCalculationCnt(str, num);
            num++;
        }
    }

    public void printCalculationCnt(String str, int num) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        int calculationCnt = 0;
        int closeCnt = 0;
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == '}') {
                closeCnt++;
            }

            if (c == '{') {
                if (closeCnt > 0) {
                    closeCnt--;
                } else {
                    calculationCnt++;
                    closeCnt++;
                }
            }
        }
        System.out.println(num + ". " + (calculationCnt + (closeCnt / 2)));
    }
}