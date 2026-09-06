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

    boolean found = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        findSum(root,targetSum,sum);
        return found;
    }

    public void findSum(TreeNode root,int targetSum,int sum){

        if (root == null){
            return;
        }

        sum = sum + root.val;
        if (sum == targetSum && (root.left == null && root.right == null)){
            found = true;
        }

        findSum(root.left,targetSum,sum);
        findSum(root.right,targetSum,sum);

    }
}