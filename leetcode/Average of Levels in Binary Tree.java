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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<Item> queue = new LinkedList<>();
        queue.add(new Item(root, 1));

        int currentLevel = 1;
        double sum = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            Item item = queue.poll();
            if (currentLevel != item.level) {
                result.add(sum / count);
                currentLevel++;
                sum = 0;
                count = 0;
            }
            sum = sum + item.node.val;
            count++;
            if (item.node.left != null) {
                queue.add(new Item(item.node.left, currentLevel + 1));
            }
            if (item.node.right != null) {
                queue.add(new Item(item.node.right, currentLevel + 1));
            }
        }
        result.add(sum / count);
        return result;
    }

    public static class Item {
        TreeNode node;
        int level;

        public Item(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}