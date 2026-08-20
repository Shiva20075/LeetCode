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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        addValues(root, map, 0, 0);

        for (Map<Integer, List<Integer>> rows : map.values()) {
            List<Integer> temp = new ArrayList<>();

            for (List<Integer> values : rows.values()) {
                Collections.sort(values);
                temp.addAll(values);
            }
            res.add(temp);
        }
        return res;
    }

    public void addValues(TreeNode root, Map<Integer, Map<Integer, List<Integer>>> map, int col, int row) {

        if (root == null) {
            return;
        }

        if (!map.containsKey(col)) {
            map.put(col, new TreeMap<>());
        }

        if (!map.get(col).containsKey(row)) {
            map.get(col).put(row, new ArrayList<>());
        }

        map.get(col).get(row).add(root.val);
        addValues(root.left, map, col - 1, row + 1);
        addValues(root.right, map, col + 1, row + 1);
    }
}