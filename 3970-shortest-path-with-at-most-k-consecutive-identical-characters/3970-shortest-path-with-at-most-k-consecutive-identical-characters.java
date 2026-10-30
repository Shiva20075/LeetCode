
class Pair {

    int curr;
    int weight;
    int count;

    Pair(int node, int weight, int count) {
        curr = node;
        this.weight = weight;
        this.count = count;
    }
}

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
        List<List<Pair>> adj = new ArrayList<>();

        int arr[][] = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
        }

        arr[0][1] = 0;

        q.add(new Pair(0, 0, 1));

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adj.get(u).add(new Pair(v, w, 0));
        }

        while (!q.isEmpty()) {

            Pair P = q.poll();

            int curr = P.curr;
            int weight = P.weight;
            int count = P.count;

            for (Pair next : adj.get(curr)) {

                int newCount;

                if (labels.charAt(curr) == labels.charAt(next.curr)) {
                    newCount = count + 1;
                } else {
                    newCount = 1;
                }

                if (newCount > k) {
                    continue;
                }

                int newWeight = weight + next.weight;

                if (newWeight < arr[next.curr][newCount]) {

                    arr[next.curr][newCount] = newWeight;

                    q.add(new Pair(next.curr, newWeight, newCount));
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {
            min = Math.min(min, arr[n - 1][i]);
        }

        if (min == Integer.MAX_VALUE) {
            return -1;
        } else {
            return min;
        }
    }
}
