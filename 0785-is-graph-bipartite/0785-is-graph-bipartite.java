class Solution {
    public boolean isBipartite(int[][] graph) {

        int V = graph.length;

        boolean[] b = new boolean[V];
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {

            if (visited[i]) {
                continue;
            }

            Queue<Integer> q = new LinkedList<>();

            q.add(i);
            visited[i] = true;
            b[i] = false;

            while (!q.isEmpty()) {

                int curr = q.poll();

                for (int node : graph[curr]) {

                    if (!visited[node]) {
                        visited[node] = true;
                        b[node] = !b[curr];
                        q.add(node);
                    } 
                    else if (b[node] == b[curr]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
