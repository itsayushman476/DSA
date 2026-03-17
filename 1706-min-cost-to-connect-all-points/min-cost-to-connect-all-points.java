import java.util.*;
class Solution {
    static class Pair {
        int node;
        int parent;
        int dist;
        Pair(int node, int parent, int dist) {
            this.node = node;
            this.parent = parent;
            this.dist = dist;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a,b) -> a.dist - b.dist);
        pq.offer(new Pair(0, -1, 0));
        int cost = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            int parent = curr.parent;
            int dist = curr.dist;
            if(visited[node]) continue;
            visited[node] = true;
            cost += dist;
            for(int i = 0; i < n; i++){
                if(!visited[i]){
                    int newDist = Math.abs(points[node][0] - points[i][0]) +
                                  Math.abs(points[node][1] - points[i][1]);
                    pq.offer(new Pair(i, node, newDist));
                }
            }
        }
        return cost;
    }
}