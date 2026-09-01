/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int lca = -1;

        List<Integer> pList = new ArrayList<>();
        List<Integer> qList = new ArrayList<>();

        findPathOfp(root, p, pList);
        findPathOfq(root, q, qList);

        List<Integer> common = new ArrayList<>(pList);
        common.retainAll(qList);
        lca = common.get(common.size() - 1);

        return findNode(root, lca);
    }

    public TreeNode findNode(TreeNode root, int lca) {

        while (root != null) {

            if (root.val == lca) {
                return root;
            }

            if (lca > root.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return null;
    }

    public void findPathOfp(TreeNode root, TreeNode p, List<Integer> pList) {

        if (root == null) {
            return;
        }

        pList.add(root.val);

        if (root == p) {
            return;
        }

        if (p.val > root.val) {
            findPathOfp(root.right, p, pList);
        } else {
            findPathOfp(root.left, p, pList);
        }
    }

    public void findPathOfq(TreeNode root, TreeNode q, List<Integer> qList) {

        if (root == null) {
            return;
        }

        qList.add(root.val);

        if (root == q) {
            return;
        }

        if (q.val > root.val) {
            findPathOfq(root.right, q, qList);
        } else {
            findPathOfq(root.left, q, qList);
        }
    }
}
