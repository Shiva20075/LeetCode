import java.util.*;

class Pair {
    int u;
    int t;

    Pair(int u, int t) {
        this.u = u;
        this.t = t;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<Pair>> adj = new ArrayList<>();
        int[] arr = new int[n + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] a : times) {

            int u = a[0];
            int v = a[1];
            int t = a[2];

            adj.get(u).add(new Pair(v, t));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.t, b.t));
        arr[k] = 0;
        pq.add(new Pair(k, 0));

        while (!pq.isEmpty()) {

            Pair p = pq.poll();
            int u = p.u;
            int t = p.t;

            if (t > arr[u]) {
                continue;
            }

            for (Pair next : adj.get(u)) {
                
                int v = next.u;
                int wt = next.t;

                if (arr[u] + wt < arr[v]) {
                    arr[v] = arr[u] + wt;
                    pq.add(new Pair(v, arr[v]));
                }
            }
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            if (arr[i] == Integer.MAX_VALUE) {
                return -1;
            }

            max = Math.max(max, arr[i]);
        }

        return max;
    }
}