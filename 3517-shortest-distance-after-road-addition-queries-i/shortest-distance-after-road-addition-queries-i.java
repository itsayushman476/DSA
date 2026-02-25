class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < n - 1; i++){
            adj.get(i).add(i + 1);
        }
        int q = queries.length;
        int[] ans = new int[q];
        for(int i = 0; i < q; i++){
            int u = queries[i][0];
            int v = queries[i][1];   
            adj.get(u).add(v);
            ans[i] = bfs(n, adj);
        }
        return ans;
    }
    public int bfs(int n, List<List<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.add(0);
        vis[0] = true;
        int level = 0;
        while(!q.isEmpty()){

            int size = q.size();   
            for(int i = 0; i < size; i++){

                int node = q.remove();   

                if(node == n - 1) return level;

                for(int nei : adj.get(node)){
                    if(!vis[nei]){
                        vis[nei] = true;
                        q.add(nei);
                    }
                }
            }

            level++;
        }

        return -1;
    }
}