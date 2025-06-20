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
    public int countNodes(TreeNode root) {
        int leftDepth = 0;
        TreeNode node = root;
        while (node != null) {
            node = node.left;
            leftDepth++;
        }
        int rightDepth = 0;
        node = root;
        while (node != null) {
            node = node.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth) {
            return (int) Math.pow(2, leftDepth) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}