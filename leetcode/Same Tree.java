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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return preOrder(p, q);
    }

    public boolean preOrder(TreeNode p, TreeNode q) {
        if (!equals(p, q)) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        return preOrder(p.left, q.left) && preOrder(p.right, q.right);
    }

    public boolean equals(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val;
    }
}