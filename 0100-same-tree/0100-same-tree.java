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

    boolean result = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {

        check(p, q);
        return result;

    }
        public void check(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null){
            return;
        }

        if (root1 == null || root2 == null) {
            result = false;
            return;
        }
        
        if (root1.val != root2.val) {
            result = false;
            return;
        }

        check(root1.left, root2.left);
        check(root1.right, root2.right);
    }
}