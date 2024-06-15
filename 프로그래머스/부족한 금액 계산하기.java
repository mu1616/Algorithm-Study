class Solution {
    public long solution(int price, int money, int count) {
        long total = 0;
        for (int i = 1; i <= count; i++) {
            total = total + ((long) price * i);
        }
        return Math.max(0, total - money);
    }
}