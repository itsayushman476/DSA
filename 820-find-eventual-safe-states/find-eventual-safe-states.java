import java.util.*;
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            for(int ele : graph[i]){
                adj.get(ele).add(i);   
                indegree[i]++;    
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(q.size() > 0){
            int front = q.remove();
            ans.add(front);
            for(int next : adj.get(front)){
                indegree[next]--;
                if(indegree[next] == 0){
                    q.add(next);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}