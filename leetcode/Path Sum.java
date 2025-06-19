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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.left == null && currentNode.right == null && currentNode.val == targetSum) {
                return true;
            }
            if (currentNode.left != null) {
                int sum = currentNode.val + currentNode.left.val;
                currentNode.left.val = sum;
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                int sum = currentNode.val + currentNode.right.val;
                currentNode.right.val = sum;
                queue.add(currentNode.right);
            }
        }
        return false;
    }
}