class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(arr -> arr[0]));

        int count = 1;
        int left = points[0][0];
        int right = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] >= left && points[i][0] <= right) {
                left = points[i][0];
                right = Math.min(right, points[i][1]);
                continue;
            }
            left = points[i][0];
            right = points[i][1];
            count++;
        }
        return count;
    }
}