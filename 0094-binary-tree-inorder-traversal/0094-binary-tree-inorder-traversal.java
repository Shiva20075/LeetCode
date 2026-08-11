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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> data = new ArrayList<>();
        inOrder(root, data);
        return data;
    }

    public void inOrder(TreeNode root, List<Integer> data) {

        if (root == null) {
            return;
        }

        inOrder(root.left, data);
        data.add(root.val);
        inOrder(root.right, data);
    }
}