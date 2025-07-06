/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeNode(nums, 0, nums.length - 1);
    }

    public TreeNode makeNode(int[] nums, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }
        int mid = (endIndex + startIndex) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        int nextStartIndex = startIndex;
        int nextEndIndex = mid - 1;
        node.left = makeNode(nums, nextStartIndex, nextEndIndex);

        nextStartIndex = mid + 1;
        nextEndIndex = endIndex;
        node.right = makeNode(nums, nextStartIndex, nextEndIndex);
        return node;
    }
}