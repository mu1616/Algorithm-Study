import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {

    public static final List<String> POSSIBLE_STRING = Arrays.stream("abcdefghijklmnopqrstuvwxyz0123456789-_.".split(""))
            .collect(Collectors.toList());

    public String solution(String new_id) {
        String id1 = process1(new_id);
        String id2 = process2(id1);
        String id3 = process3(id2);
        String id4 = process4(id3);
        String id5 = process5(id4);
        String id6 = process6(id5);
        String id7 = process7(id6);
        return id7;
    }

    private String process1(String id) {
        char[] currentArray = id.toCharArray();
        char[] newArray = new char[currentArray.length];
        for (int i = 0; i < currentArray.length; i++) {
            char c = currentArray[i];
            if (isUpperCase(c)) {
                newArray[i] = toLowerCase(c);
            } else {
                newArray[i] = c;
            }
        }
        return new String(newArray);
    }

    private String process2(String id) {
        return Arrays.stream(id.split(""))
                .filter(POSSIBLE_STRING::contains)
                .collect(Collectors.joining());
    }

    private String process3(String id) {
        char[] currentChars = id.toCharArray();
        List<Character> newChars = new ArrayList<>();
        newChars.add(currentChars[0]);
        for (int i = 1; i < currentChars.length; i++) {
            char c = currentChars[i];
            if (c == '.' && currentChars[i - 1] == '.') {
                continue;
            }
            newChars.add(c);
        }
        return newChars.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private String process4(String id) {
        String newId = id;
        if (newId.charAt(0) == '.') {
            newId = id.substring(1);
        }
        if (newId.length() > 0 && newId.charAt(newId.length() - 1) == '.') {
            newId = newId.substring(0, newId.length() - 1);
        }
        return newId;
    }

    private String process5(String id) {
        if (id.equals("")) {
            return "a";
        }
        return id;
    }

    private String process6(String id) {
        if (id.length() >= 16) {
            return process4(id.substring(0, 15));
        }
        return id;
    }

    private String process7(String id) {
        String newId = id;
        if (id.length() <= 3) {
            String lastStr = id.substring(id.length() - 1);
            for (int i = 0; i < 3 - id.length(); i++) {
                newId = newId + lastStr;
            }
        }
        return newId;
    }

    private boolean isUpperCase(char c) {
        return c >= 65 && c <= 90;
    }

    private char toLowerCase(char c) {
        return (char) (c + 32);
    }
}