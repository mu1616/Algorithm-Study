import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solution();
    }

    public void solution() {
        int t = scanner.nextInt();
        String[] words = new String[t];
        for (int i = 0; i < t; i++) {
            words[i] = scanner.next();
            testCase(words[i]);
        }
    }

    public void testCase(String word) {
        char[] chars = word.toCharArray();
        int firstIndex = -1;
        for (int i = chars.length - 2; i >= 0; i--) {
            if (chars[i] < chars[i + 1]) {
                firstIndex = i;
                break;
            }
        }
        if (firstIndex == -1) {
            System.out.println(word);
            return;
        }
        int swapIndex = -1;
        int swapValue  = Integer.MAX_VALUE;
        for (int i = firstIndex + 1; i < chars.length; i++) {
            if (chars[firstIndex] < chars[i] && swapValue > chars[i]) {
                swapIndex = i;
                swapValue = chars[i];
            }
        }
        swap(chars, firstIndex, swapIndex);
        char[] prefix = new char[firstIndex + 1];
        for (int i = 0; i < prefix.length; i++) {
            prefix[i] = chars[i];
        }
        char[] suffix = new char[chars.length - prefix.length];
        for (int i = 0; i < suffix.length; i++) {
            suffix[i] = chars[i + prefix.length];
        }
        Arrays.sort(suffix);
        System.out.println(new String(prefix) + new String(suffix));
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}