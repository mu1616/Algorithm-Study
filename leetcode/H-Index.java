class Solution {
    public int hIndex(int[] citations) {
        int[] counts = new int[1001];
        for (int i = 0; i < citations.length; i++) {
            counts[citations[i]]++;
        }
        int sum = 0;
        for (int i = 1000; i >= 0; i--) {
            sum = sum + counts[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}