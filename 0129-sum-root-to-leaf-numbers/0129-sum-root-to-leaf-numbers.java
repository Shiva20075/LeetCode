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
    public int sumNumbers(TreeNode root) {
        
        List<Integer> l = new ArrayList<>();
        findPaths(root,l,0);
        int sum = 0;

        for (int n : l){
            sum = sum + n;
        }
        return sum;
    }

    public void findPaths(TreeNode root,List<Integer> l,int num){

        if (root == null){
            return;
        }

        num = num * 10 + root.val;

        if (root.left == null && root.right == null){
            l.add(num);
        }
        
        findPaths(root.left,l,num);
        findPaths(root.right,l,num);
    }
}