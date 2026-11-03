class Pair {

    int node;
    int weight;

    Pair(int node,int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

       for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
       }

       for (int i = 0; i < times.length; i++) {
        
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            adj.get(u).add(new Pair(v,w));
       }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.weight,b.weight));
        pq.add(new Pair(k,0));

        while (!pq.isEmpty()) {
            
            Pair p = pq.poll();
            int curr = p.node;
            int weight = p.weight;

            if (weight > dist[curr]) {
                continue;
            }

            for (Pair neighbor : adj.get(curr)) {

                int neig = neighbor.node;
                int nWeight = neighbor.weight;

                if (weight + nWeight < dist[neig]){
                    dist[neig] = weight + nWeight;
                    pq.add(new Pair(neig,dist[neig]));
                }
                
            }
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            max = Math.max(max, dist[i]);
        }

        return max;
    }
}