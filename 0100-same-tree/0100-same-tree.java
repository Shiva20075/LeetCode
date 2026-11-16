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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        Queue<TreeNode> pq = new LinkedList<>();
        pq.add(p);
        pq.add(q);

        while (!pq.isEmpty()) {

            int size = pq.size();

            for (int i = 0; i < size; i++) {

                TreeNode p1 = pq.poll();
                TreeNode q1 = pq.poll();

                if (p1 == null && q1 == null) {
                    break;
                }

                if (p1 == null || q1 == null) {
                    return false;
                }

                if (p1.val != q1.val) {
                    return false;
                }

                pq.add(p1.left);
                pq.add(q1.left);
                pq.add(p1.right);
                pq.add(q1.right);
            }
        }

        return true;
    }
}