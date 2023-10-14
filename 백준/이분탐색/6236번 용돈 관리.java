import java.util.*;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int result = 0;
        int left = 0;
        int right = 1000000000;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(arr, mid, m)) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }

    public boolean isPossible(int[] arr, int money, int m) {
        int currentMoney = 0;
        int withdrawCnt = 0;
        for (int i = 0; i < arr.length; i++) {
            int needMoney = arr[i];
            if (currentMoney >= needMoney) {
                currentMoney = currentMoney - needMoney;
                continue;
            }
            withdrawCnt++;
            currentMoney = money;
            if (currentMoney < needMoney) {
                return false;
            }
            currentMoney = currentMoney - needMoney;
        }
        return withdrawCnt <= m;
    }
}
