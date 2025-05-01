class Solution {
    public boolean find132pattern(int[] nums) {
        int[] mins = new int[nums.length];
        mins[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            mins[i] = Math.min(mins[i - 1], nums[i]);
        }

        Stack<Integer> stack = new Stack<>();
        for (int j = nums.length - 1; j >= 1; j--) {
            if (nums[j] <= mins[j]) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() <= mins[j]) {
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() < nums[j]) {
                return true;
            }
            stack.push(nums[j]);
        }
        return false;
    }
}