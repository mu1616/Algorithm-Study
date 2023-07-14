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
        int n = scanner.nextInt();
        List<Column> columns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            columns.add(new Column(scanner.nextInt(), scanner.nextInt()));
        }
        columns.sort(Comparator.comparingInt(column -> column.location));
        recursive(columns, 0, false, 0);
    }

    public void recursive(List<Column> columns, int currentIndex, boolean changeDirection, int sum) {
        Column currentColumn = columns.get(currentIndex);
        sum = sum + currentColumn.height;
        if (currentIndex == columns.size() - 1) {
            System.out.println(sum);
            return;
        }
        int downLimit = 0;
        for (int i = currentIndex + 1; i <  columns.size(); i++) {
            if (columns.get(i).height > currentColumn.height) {
                if (!changeDirection) {
                    recursive(columns, i, false, sum + (currentColumn.height * (columns.get(i).location - currentColumn.location - 1)));
                }
                break;
            }
            if (columns.get(i).height > downLimit) {
                recursive(columns, i, true, sum + (columns.get(i).height * (columns.get(i).location - currentColumn.location - 1)));
                downLimit = columns.get(i).height;
            }
        }
    }

    public class Column {
        int location;
        int height;

        public Column(int location, int height) {
            this.location = location;
            this.height = height;
        }
    }
}