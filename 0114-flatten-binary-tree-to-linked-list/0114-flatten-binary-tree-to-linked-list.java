class Solution {

    public void flatten(TreeNode root) {

        List<TreeNode> l = new ArrayList<>();
        preOrder(root, l);

        for (int i = 0; i < l.size() - 1; i++) {

            TreeNode n1 = l.get(i);
            TreeNode n2 = l.get(i + 1);

            n1.left = null;
            n1.right = n2;
        }

        if (!l.isEmpty()) {

            TreeNode last = l.get(l.size() - 1);
            last.left = null;
            last.right = null;
        }
    }

    public void preOrder(TreeNode root, List<TreeNode> l) {

        if (root == null) return;

        l.add(root);
        preOrder(root.left, l);
        preOrder(root.right, l);
    }
}