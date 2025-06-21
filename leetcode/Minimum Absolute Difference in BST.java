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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        inOrder(root, list);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            int diff = list.get(i) - list.get(i - 1);
            min = Math.min(diff, min);
        }
        return min;
    }

    public void inOrder(TreeNode node, List<Integer> list) {
        if (node.left != null) {
            inOrder(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            inOrder(node.right, list);
        }
    }
}