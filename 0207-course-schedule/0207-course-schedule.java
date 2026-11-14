class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        boolean b[] = new boolean[numCourses];
        boolean p[] = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {

            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj.get(v).add(u);
        }

        for (int i = 0; i < numCourses; i++) {

            if (!b[i]) {
                if (dfs(i, adj, b, p)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int i, List<List<Integer>> adj,boolean b[], boolean p[]) {

        b[i] = true;
        p[i] = true;

        for (int neib : adj.get(i)) {

            if (!b[neib]) {

                if (dfs(neib, adj, b, p)) {
                    return true;
                }

            } else if (p[neib]) {
                return true;
            }
        }

        p[i] = false;
        return false;
    }
}