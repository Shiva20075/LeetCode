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

    List<Integer> l = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        findPath(root,targetSum,0);
        return res;
    }

    public void findPath(TreeNode root,int targetSum,int sum){

        if (root == null){
            return;
        }

        l.add(root.val);
        sum += root.val;

        if (sum == targetSum && (root.left == null && root.right == null)){
            res.add(new ArrayList<>(l));
        }

        findPath(root.left,targetSum,sum);
        findPath(root.right,targetSum,sum);
        l.remove(l.size() - 1);
    }
}