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

class Pair {

    TreeNode node;
    int num;

    Pair(TreeNode node, int num) {

        this.node = node;
        this.num = num;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        
        if (root == null) {
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int maxWidth = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            int first = 0;
            int last = 0;

            for (int i = 0; i < size; i++) {

                Pair p = q.poll();
                TreeNode node = p.node;
                int n = p.num;

                if (i == 0) {
                    first = n;
                }
                if (i == size - 1) {
                    last = n;
                }

                if (node.left != null) {
                    q.add(new Pair(node.left, 2 * n + 1));
                }
                if (node.right != null) {
                    q.add(new Pair(node.right, 2 * n + 2));
                }
            }

            int width = last - first + 1;
            maxWidth = Math.max(maxWidth, width);
        }

        return maxWidth;
    }
}