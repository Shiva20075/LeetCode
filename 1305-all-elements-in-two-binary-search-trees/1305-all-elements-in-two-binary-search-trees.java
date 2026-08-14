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

    List<Integer> list = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        tree1(root1);
        tree2(root2);

        Collections.sort(list);

        return list;
    }

    public void tree1(TreeNode root) {

        if (root == null) {
            return;
        }

        list.add(root.val);

        tree1(root.left);
        tree1(root.right);
    }

    public void tree2(TreeNode root) {

        if (root == null) {
            return;
        }

        list.add(root.val);

        tree2(root.left);
        tree2(root.right);
    }
}