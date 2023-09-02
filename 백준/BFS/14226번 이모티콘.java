import java.io.*;
import java.util.*;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    public void solve() throws IOException {
        int s = scanner.nextInt();
        System.out.println(bfs(s));
    }

    public int bfs(int s) {
        Queue<Chatting> queue = new LinkedList<>();
        boolean visited[][] = new boolean[1001][1001];
        visited[1][0] = true;
        queue.add(new Chatting(1, 0, 0));

        while(!queue.isEmpty()) {
            Chatting currentChat = queue.poll();

            Chatting nextChat1 = new Chatting(currentChat.screenEmojiCount, currentChat.screenEmojiCount, currentChat.time + 1);
            Chatting nextChat2 = new Chatting(currentChat.screenEmojiCount + currentChat.clipBoardEmojiCount, currentChat.clipBoardEmojiCount, currentChat.time + 1);
            Chatting nextChat3 = new Chatting(currentChat.screenEmojiCount - 1, currentChat.clipBoardEmojiCount, currentChat.time + 1);

            if (nextChat1.clipBoardEmojiCount != currentChat.clipBoardEmojiCount && nextChat1.clipBoardEmojiCount <= 1000 && !visited[nextChat1.screenEmojiCount][nextChat1.clipBoardEmojiCount]) {
                visited[nextChat1.screenEmojiCount][nextChat1.clipBoardEmojiCount] = true;
                queue.add(nextChat1);
            }
            if (currentChat.clipBoardEmojiCount != 0 && nextChat2.screenEmojiCount >= 2 && nextChat2.screenEmojiCount <= 1000 && !visited[nextChat2.screenEmojiCount][nextChat2.clipBoardEmojiCount]) {
                if (nextChat2.screenEmojiCount == s) {
                    return nextChat2.time;
                }
                visited[nextChat2.screenEmojiCount][nextChat2.clipBoardEmojiCount] = true;
                queue.add(nextChat2);
            }
            if (nextChat3.screenEmojiCount >= 2 && nextChat3.screenEmojiCount <= 1000 && !visited[nextChat3.screenEmojiCount][nextChat3.clipBoardEmojiCount]) {
                if (nextChat3.screenEmojiCount == s) {
                    return nextChat3.time;
                }
                visited[nextChat3.screenEmojiCount][nextChat3.clipBoardEmojiCount] = true;
                queue.add(nextChat3);
            }
        }
        throw new IllegalStateException();
    }


    static class Chatting {
        int screenEmojiCount;
        int clipBoardEmojiCount;
        int time;

        public Chatting(int screenEmojiCount, int clipBoardEmojiCount, int time) {
            this.screenEmojiCount = screenEmojiCount;
            this.clipBoardEmojiCount = clipBoardEmojiCount;
            this.time = time;
        }
    }
}
