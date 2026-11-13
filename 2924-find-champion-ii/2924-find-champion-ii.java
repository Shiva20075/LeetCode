class Solution {
    public int findChampion(int n, int[][] edges) {

        int count = 0;
        int champion = -1;

        int[] indegree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
        }

        for (int i = 0; i < n; i++) {

            for (int v : adj.get(i)) {
                indegree[v]++;
            }
        }

        for (int i = 0; i < n; i++) {

            if (indegree[i] == 0) {
                count++;
                champion = i;
            }
        }

        return count == 1 ? champion : -1;
    }
}