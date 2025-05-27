class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        for (int n : map.keySet()) {
            if (map.get(n).size() < 2) {
                continue;
            }
            for (int i = 0; i < map.get(n).size() - 1; i++) {
                if (map.get(n).get(i + 1) - map.get(n).get(i) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}