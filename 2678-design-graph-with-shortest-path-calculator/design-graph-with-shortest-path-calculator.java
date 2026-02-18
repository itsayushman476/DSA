import java.util.*;

class Graph {

    List<int[]>[] adj;
    int n;

    // Constructor
    public Graph(int n, int[][] edges) {
        this.n = n;
        adj = new ArrayList[n];

        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }

        // build graph
        for(int[] e : edges){
            adj[e[0]].add(new int[]{e[1], e[2]}); // {to, weight}
        }
    }

    // Add new edge
    public void addEdge(int[] edge) {
        adj[edge[0]].add(new int[]{edge[1], edge[2]});
    }

    // Shortest Path using Dijkstra
    public int shortestPath(int node1, int node2) {

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a,b)->a[1]-b[1]);

        dist[node1] = 0;
        pq.add(new int[]{node1, 0}); // {node, cost}

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int u = cur[0];
            int cost = cur[1];
            if(u == node2) return cost;

            if(cost > dist[u]) continue;

            for(int[] nei : adj[u]){
                int v = nei[0];
                int w = nei[1];

                if(cost + w < dist[v]){
                    dist[v] = cost + w;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        return -1;
    }
}

