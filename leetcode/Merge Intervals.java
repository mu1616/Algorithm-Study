class Solution {
    public int[][] merge(int[][] intervals) {
        Comparator<int[]> comparator = Comparator.comparingInt((int[] arr) -> arr[0]);
        Arrays.sort(intervals, comparator);

        List<int[]> list = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= right) {
                right = Math.max(right, intervals[i][1]);
                continue;
            }
            list.add(new int[]{left, right});
            left = intervals[i][0];
            right = intervals[i][1];
        }

        list.add(new int[]{left, right});
        return list.toArray(int[][]::new);
    }
}