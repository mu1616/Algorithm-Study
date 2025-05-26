class Solution {
    public boolean isHappy(int n) {
        String numStr = String.valueOf(n);
        Set<Integer> set = new HashSet<>();
        while (true) {
            int sum = 0;
            for (String numSplit : numStr.split("")) {
                int n1 = Integer.valueOf(numSplit);
                sum = sum + (n1 * n1);
            }
            if (sum == 1) {
                break;
            }
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            numStr = String.valueOf(sum);
        }
        return true;
    }
}