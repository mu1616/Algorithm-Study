class Solution {
    public int majorityElement(int[] nums) {
        int targetCount = nums.length / 2 + 1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) == targetCount) {
                return nums[i];
            }
        }
        
        throw new IllegalStateException();
    }
}