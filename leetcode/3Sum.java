class Solution {
     public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        for (int j = 0; j <= nums.length - 2; j++) {
            int i = j - 1;
            int k = j + 1;
            while (i >= 0 && k <= nums.length - 1) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    i--;
                } else if (sum == 0) {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    i--;
                } else {
                    k++;
                }
            }
        }
        return new ArrayList<>(result);
    }
}