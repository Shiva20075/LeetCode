class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        boolean b[] = new boolean[numCourses];
        Set<Integer> s = new HashSet<>();

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
                if (findCycle(adj, b, i, s, l)) {
                    return new int[0];
                }
            }
        }

        Collections.reverse(l);

        int res[] = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            res[i] = l.get(i);
        }

        return res;
    }

    public boolean findCycle(List<List<Integer>> adj, boolean b[], int curr,Set<Integer> s, List<Integer> l) {

        b[curr] = true;
        s.add(curr);

        for (int node : adj.get(curr)) {

            if (s.contains(node)) {
                return true;
            }

            if (!b[node]) {
                if (findCycle(adj, b, node, s, l)) {
                    return true;
                }
            }
        }

        s.remove(curr);
        l.add(curr);

        return false;
    }
}