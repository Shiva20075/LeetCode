
import java.util.Arrays;

class Solution {

    int rank[];
    int parent[];

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        rank = new int[n];
        parent = new int[n];
        Arrays.fill(rank, 0);

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            union(u, v);
        }

        findUltParent(source);
        findUltParent(destination);

        return parent[source] == parent[destination];
    }

    public void union(int u, int v) {

        int upU = findUltParent(u);
        int upV = findUltParent(v);

        if (upU == upV) {
            return;
        }

        if (rank[upU] > rank[upV]) {
            parent[upV] = upU;
        }
        else if (rank[upU] < rank[upV]) {
            parent[upU] = upV;
        }
        else {
            parent[upV] = upU;
            rank[upU]++;
        }
    }

    public int findUltParent(int u) {

        if (u == parent[u]) {
            return u;
        }

        int ultPar = findUltParent(parent[u]);
        parent[u] = ultPar;
        
        return ultPar;
    }
}
