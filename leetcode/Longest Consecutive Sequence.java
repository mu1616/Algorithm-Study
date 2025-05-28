class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = Arrays.stream(nums)
                .mapToObj(i -> i)
                .collect(Collectors.toSet());
        
        int result = 1;
        for(int n : set) {
            int length = 1;
            if(set.contains(n - 1)) {
               continue;
            }
            int i = 1;
            while(set.contains(n + i)) {
                length++;
                i++;
            }
            result = Math.max(result, length);
        }
        return result;
    }
}