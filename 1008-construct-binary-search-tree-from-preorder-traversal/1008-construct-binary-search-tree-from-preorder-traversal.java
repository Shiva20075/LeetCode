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

    public TreeNode bstFromPreorder(int[] preorder) {

        int[] sorted = preorder.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> m = new TreeMap<>();

        for (int i = 0; i < sorted.length; i++) {
            m.put(sorted[i], i);
        }
        return buildTree(preorder, m, 0, preorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, Map<Integer, Integer> m, int left, int right) {

        if (left > right) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIdx++]);
        int idx = m.get(root.val);

        root.left = buildTree(preorder, m, left, idx - 1);
        root.right = buildTree(preorder, m, idx + 1, right);
        return root;
    }
}