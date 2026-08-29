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
    public int findBottomLeftValue(TreeNode root) {

        Map<Integer, Integer> map = new HashMap<>();
        findDepth(root, 0, map);
        int maxDepth = 0;

        for (int depth : map.keySet()) {
            maxDepth = Math.max(maxDepth, depth);
        }

        return map.get(maxDepth);
    }

    public void findDepth(TreeNode root, int depth, Map<Integer, Integer> map) {

        if (root == null) {
            return;
        }

        if (!map.containsKey(depth)) {
            map.put(depth, root.val);
        }

        findDepth(root.left, depth + 1, map);
        findDepth(root.right, depth + 1, map);
    }
}
