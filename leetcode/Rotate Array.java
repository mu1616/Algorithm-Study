class Solution {
    public void rotate(int[] nums, int k) {
        int[] copy = Arrays.stream(nums).toArray();
        for (int i = 0; i < nums.length; i++) {
            int changedIndex = (i + k) % nums.length;
            nums[changedIndex] = copy[i];
        }
    }
}