class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexMap.putIfAbsent(nums[i], new ArrayList<>());
            indexMap.get(nums[i]).add(i);
        }

        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                break;
            }
            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        int index1 = indexMap.get(nums[left]).get(0);
        indexMap.get(nums[left]).remove(0);
        int index2 = indexMap.get(nums[right]).get(0);
        
        return new int[]{index1, index2};
    }
}