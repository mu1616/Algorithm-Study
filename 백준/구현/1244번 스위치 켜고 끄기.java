import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        int switchCnt = scanner.nextInt();
        int[] switches = new int[switchCnt];
        for (int i = 0; i < switchCnt; i++) {
            switches[i] = scanner.nextInt();
        }
        int studentCnt = scanner.nextInt();

        for (int i = 0; i < studentCnt; i++) {
            int gender = scanner.nextInt();
            int switchNum = scanner.nextInt();

            if (gender == 1) {
                changeSwitchForMan(switches, switchNum);
            } else if (gender == 2) {
                changeSwitchForWoman(switches, switchNum);
            } else {
                throw new IllegalStateException();
            }
        }
        printSwitch(switches);
    }

    public void changeSwitchForMan(int[] switches, int switchNum) {
        int multiple = 1;
        while(switchNum * multiple <= switches.length) {
            switches[switchNum * multiple - 1] = getChangedSwitchValue(switches[switchNum * multiple - 1]);
            multiple++;
        }
    }

    public void changeSwitchForWoman(int[] switches, int switchNum) {
        switches[switchNum - 1] = getChangedSwitchValue(switches[switchNum - 1]);
        int i = 1;
        while(true) {
            if (switchNum - i - 1 < 0 || switchNum + i - 1 > switches.length - 1) {
                break;
            }
            if (switches[switchNum - i - 1] == switches[switchNum + i - 1]) {
                switches[switchNum - i - 1] = getChangedSwitchValue(switches[switchNum - i - 1]);
                switches[switchNum + i - 1] = getChangedSwitchValue(switches[switchNum + i - 1]);
                i++;
            } else {
                break;
            }
        }
    }

    public void printSwitch(int[] switches) {
        for (int i = 0; i <= switches.length / 20; i++) {
            String line = Arrays.stream(switches)
                    .skip(i * 20L)
                    .limit(20)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));
            System.out.println(line);
        }
    }

    public int getChangedSwitchValue(int switchValue) {
        if (switchValue == 0) {
            return 1;
        }
        if (switchValue == 1) {
            return 0;
        }
        throw new IllegalStateException();
    }
}