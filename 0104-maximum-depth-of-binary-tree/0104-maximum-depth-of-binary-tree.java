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
    int MaxCount = 0;
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int count = 0;
        findMaxDepth(root, 1);

        return MaxCount;
    }

    public void findMaxDepth(TreeNode root, int count) {

        if (root == null) {
            return;
        }

        if (root.left != null || root.right != null) {
            count++;
        }

        if (count > MaxCount) {
            MaxCount = count;
        }

        findMaxDepth(root.left, count);
        findMaxDepth(root.right, count);
    }
}