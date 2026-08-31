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
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode node = new TreeNode(val);
        InsertNode(root,node);
        return root;
    }

    public void InsertNode(TreeNode root,TreeNode node){

        if (root == null){
            return ;
        }

        if (node.val < root.val && root.left == null){
            root.left = node;
            return;
        }

        if(node.val > root.val && root.right == null){
            root.right = node;
            return;
        }

        if(node.val > root.val){
            InsertNode(root.right,node);
        }else{
            InsertNode(root.left,node);
        }
    }
}