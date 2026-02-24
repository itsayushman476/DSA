class Solution {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {

        // build graph
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
        }

        // answer list
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++) ans.add(new ArrayList<>());

        // run DFS from every node
        for(int i=0;i<n;i++){
            boolean[] visited = new boolean[n];
            dfs(i, i, adj, visited, ans);
        }

        return ans;
    }

    // start = ancestor
    // node = current node
    private void dfs(int start, int node, List<List<Integer>> adj,
                     boolean[] visited, List<List<Integer>> ans){

        for(int next : adj.get(node)){
            if(!visited[next]){
                visited[next] = true;

                // start is ancestor of next
                ans.get(next).add(start);

                dfs(start, next, adj, visited, ans);
            }
        }
    }
}