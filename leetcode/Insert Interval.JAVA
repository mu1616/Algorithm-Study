class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }
        List<int[]> result = new ArrayList<>();

        boolean mergeComplete = false;
        for (int i = 0; i < intervals.length; i++) {
            if (!mergeComplete && newInterval[0] <= intervals[i][1]) {
                int left = Math.min(intervals[i][0], newInterval[0]);
                int right = newInterval[1];
                while (i < intervals.length) {
                    if (newInterval[1] < intervals[i][0]) {
                        break;
                    }
                    right = Math.max(right, intervals[i][1]);
                    i++;
                }
                result.add(new int[]{left, right});
                mergeComplete = true;
            }
            if (i < intervals.length) {
                result.add(intervals[i]);
            }
        }
        if (!mergeComplete) {
            result.add(newInterval);
        }
        return result.toArray(int[][]::new);
    }
}