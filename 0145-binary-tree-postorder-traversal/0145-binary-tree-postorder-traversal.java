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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> data = new ArrayList<>();
        postOrder(root, data);
        return data;
    }

    public void postOrder(TreeNode root, List<Integer> data) {

        if (root == null) {
            return;
        }

        postOrder(root.left, data);
        postOrder(root.right, data);
        data.add(root.val);
    }
}