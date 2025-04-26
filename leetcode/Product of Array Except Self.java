class Solution {
    public int[] productExceptSelf(int[] nums) {
        int dp1[] = new int[nums.length];
        int dp2[] = new int[nums.length];

        dp1[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp1[i] = dp1[i - 1] * nums[i];
        }

        dp2[0] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            dp2[i] = dp2[i - 1] * nums[nums.length - 1 - i];
        }

        int[] answer = new int[nums.length];
        for (int i = 0; i < answer.length; i++) {
            int dp1Index = i - 1;
            int dp2Index = answer.length - 2 - i;
            if (dp1Index < 0) {
                answer[i] = dp2[dp2Index];
            } else if (dp2Index < 0) {
                answer[i] = dp1[dp1Index];
            } else {
                answer[i] = dp1[dp1Index] * dp2[dp2Index];
            }
        }
        return answer;
    }
}