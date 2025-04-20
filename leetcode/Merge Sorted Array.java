class Solution {
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        for (int l = i; l >= 0; l--) {
            nums1[k] = nums1[l];
            k--;
        }
        for (int l = j; l >= 0; l--) {
            nums1[k] = nums2[l];
            k--;
        }
    }
}