
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        boolean b[] = new boolean[numCourses];
        boolean p[] = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int a = pair[0];
            int c = pair[1];

            adj.get(c).add(a);
        }

        for (int i = 0; i < numCourses; i++) {

            if (!b[i]) {
                if (dfs(adj, b, p, i, st)) {
                    return new int[0];
                }
            }
        }

        int res[] = new int[numCourses];
        int idx = 0;

        while (!st.isEmpty()) {
            res[idx++] = st.pop();
        }

        return res;
    }

    public boolean dfs(List<List<Integer>> adj,boolean b[],boolean p[],int curr,Stack<Integer> st) {

        b[curr] = true;
        p[curr] = true;

        for (int node : adj.get(curr)) {

            if (!b[node]) {

                if (dfs(adj, b, p, node, st)) {
                    return true;
                }

            } else if (p[node]) {
                return true;
            }
        }

        p[curr] = false;
        st.push(curr);
        return false;
    }
}
