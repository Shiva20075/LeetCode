class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        boolean b[] = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {

            int a = pair[0];
            int c = pair[1];
            adj.get(c).add(a);
        }

        for (int i = 0; i < adj.size(); i++) {
            if (findCycle(adj, b, i, s)) {
                return false;
            }
        }

        return true;
    }

    public boolean findCycle(List<List<Integer>> adj, boolean b[], int curr, Set<Integer> s) {

        b[curr] = true;
        s.add(curr);

        for (int node : adj.get(curr)) {

            if (s.contains(node)) {
                return true;
            }

            if (!b[node]) {
                if (findCycle(adj, b, node, s)) {
                    return true;
                }
            }
        }

        s.remove(curr);
        return false;

    }
}