// 후위표기식 에서 가장 집중해야할 것 
// 1. 우선순위가 높은 연산의 연산자가 가장 왼쪽에 위치한다.
// 2. 피연산자는 무조건 왼쪽부터 순서대로 위치한다.
//
import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solution();
    }

    public void solution() {
        String input = scan.next();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('(', 0);
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            switch(ch) {
                case '(' :
                    stack.push(ch);
                    break;

                case ')' :
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;

                case '+' :
                case '-' :
                case '*' :
                case '/' :
                    while (!stack.isEmpty() && map.get(stack.peek()) >= map.get(ch)) {
                        sb.append(stack.pop());
                    }
                    stack.push(ch);
                    break;

                default :
                    sb.append(ch);
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }
}
