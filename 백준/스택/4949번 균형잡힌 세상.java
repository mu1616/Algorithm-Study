import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solution();
    }

    public void solution() {
        String str;
        while (!(str = scanner.nextLine()).equals(".")) {
            if (isParallel(str)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    public boolean isParallel(String str) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (char c : str.toCharArray()) {
            if (isBracket(c)) {
                stack1.push(c);
            }
        }

        while (!stack1.isEmpty()) {
            char bracket = stack1.pop();

            if (isCloseBracket(bracket)) {
                stack2.push(bracket);
                continue;
            }

            if (isOpenBracket(bracket)) {
                if (stack2.isEmpty()) {
                    return false;
                }

                char lastPushedCloseBracket = stack2.peek();
                if (isPair(bracket, lastPushedCloseBracket)) {
                    stack2.pop();
                } else {
                    return false;
                }
            }
        }

        return stack2.isEmpty();
    }

    public boolean isBracket(char bracket) {
        return isOpenBracket(bracket) || isCloseBracket(bracket);
    }

    public boolean isOpenBracket(char bracket) {
        return bracket == '[' || bracket == '(';
    }

    public boolean isCloseBracket(char bracket) {
        return bracket == ']' || bracket == ')';
    }

    public boolean isPair(char openBracket, char closeBracket) {
        return (openBracket == '(' && closeBracket == ')') ||
                (openBracket == '[' && closeBracket == ']');
    }
}
