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

    int preIdx = 0;
    Map<Integer, Integer> inOrder = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            inOrder.put(inorder[i], i);
        }

        return buildTree(preorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int left, int right) {
        
        if (left > right) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIdx++]);
        int index = inOrder.get(root.val);

        root.left = buildTree(preorder, left, index - 1);
        root.right = buildTree(preorder, index + 1, right);

        return root;
    }
}
