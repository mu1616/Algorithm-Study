class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                nums[j] = val - 1;
                j--;
                count++;
            } else {
                i++;
            }
        }
        return nums.length - count;
    }
}