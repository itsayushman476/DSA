import java.util.*;
class Solution {
    public class Pair {
        int node;
        int time;
        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int src) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int t = times[i][2];
            adj.get(u).add(new Pair(v, t)); 
        }
        int[] ans = new int[n + 1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0; 
        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair top = pq.remove();
            int node = top.node; 
            int time = top.time; 
            for (Pair p : adj.get(node)) {
                int totalTime = time + p.time;
                if (totalTime < ans[p.node]) {
                    ans[p.node] = totalTime;
                    pq.add(new Pair(p.node, totalTime));
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (ans[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, ans[i]); 
        }
        return max; 
    }
}