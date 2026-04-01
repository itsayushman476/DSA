import java.util.*;
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
            indegree[e[0]]++;
            indegree[e[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                q.offer(i);
            }
        }
        int remainingNodes = n;
        while (remainingNodes > 2) {
            int size = q.size();
            remainingNodes -= size;
            for (int i = 0; i < size; i++) {
                int leaf = q.poll();
                for (int neighbor : graph.get(leaf)) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 1) {
                        q.offer(neighbor);
                    }
                }
            }
        }
        return new ArrayList<>(q);
    }
}