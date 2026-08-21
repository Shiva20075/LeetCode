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

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        List<Integer> list = new ArrayList<>();
        addDepth(root, 1, list);
        return Collections.min(list);
    }

    public void addDepth(TreeNode root, int count, List<Integer> list) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            list.add(count);
            return;
        }

        addDepth(root.left, count + 1, list);
        addDepth(root.right, count + 1, list);
    }
}