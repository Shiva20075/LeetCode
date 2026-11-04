class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        double res[] = new double [n];
        Arrays.fill(res,0.0);
        res[start_node] = 1.0;

        for (int i = 0; i < n-1; i++) {

            for (int j = 0; j < edges.length; j++) {

                int u = edges[j][0];
                int v = edges[j][1];
                double w = succProb[j];

                if (res[u] * w > res[v]) {
                    res[v] = res[u] * w;
                }

                if (res[v] * w > res[u]) {
                    res[u] = res[v] * w;
                }
            }
        }

        return res[end_node];
    }
}