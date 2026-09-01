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
    public int kthSmallest(TreeNode root, int k) {

        List<Integer> l = new ArrayList<>();
        doInorder(root, l);

        return l.get(k - 1);
    }

    public void doInorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        doInorder(root.left, list);
        list.add(root.val);
        doInorder(root.right, list);
    }
}
