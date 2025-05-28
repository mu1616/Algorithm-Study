class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        int i = 0;
        while (i < nums.length) {
            int leftNum = nums[i];
            while (i < nums.length - 1 && nums[i] == nums[i + 1] - 1) {
                i++;
            }
            int rightNum = nums[i];
            if (leftNum == rightNum) {
                result.add(String.valueOf(leftNum));
            } else {
                result.add(String.format("%s->%s", leftNum, rightNum));
            }
            i++;
        }
        return result;
    }
}