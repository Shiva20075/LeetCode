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

    Map<Integer,Integer> m = new TreeMap<>();

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        dfs(root,0);

        for (int val :m.values()) {
            res.add(val);
        }
        return res;
    }

    public void dfs(TreeNode root,int height) {

        if (root == null) return;

        if (!m.containsKey(height)) {
            m.put(height,root.val);
        }

        dfs(root.right,height+1);
        dfs(root.left,height+1);
    }
}