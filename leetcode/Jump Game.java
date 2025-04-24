class Solution {

    public boolean canJump(int[] nums) {
        int currentPosition = 0;
        while (currentPosition < nums.length - 1) {
            int maxJumpLength = nums[currentPosition];
            if (maxJumpLength == 0) {
                return false;
            }
            
            int nextPosition = currentPosition + 1;
            for (int i = 2; i <= maxJumpLength; i++) {
                int candidateNextPosition = currentPosition + i;
                if (candidateNextPosition >= nums.length) {
                    break;
                }
                if (nextPosition + nums[nextPosition] < candidateNextPosition + nums[candidateNextPosition]) {
                    nextPosition = candidateNextPosition;
                }
            }
            currentPosition = nextPosition;
        }
        return true;
    }
}