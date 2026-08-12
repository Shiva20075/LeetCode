class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) {
            return ans;
        }

        q.add(root);

        while (!q.isEmpty()) {

            List<Integer> e = new ArrayList<>();
            int size = q.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();
                e.add(node.val);

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }

            ans.add(e);
        }

        return ans;
    }
}