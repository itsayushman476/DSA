class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[]r:roads){
            adj.get(r[0]).add(new int[]{r[1], r[2]});
            adj.get(r[1]).add(new int[]{r[0], r[2]});
        }
        boolean visited[]=new boolean[n+1];
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        visited[1]=true;
        int min=Integer.MAX_VALUE;
        while(q.size()>0){
            int city=q.poll();
            for(int[]nei:adj.get(city)){
                int nextcity=nei[0];
                int dist=nei[1];
                min=Math.min(min,dist);
                if(!visited[nextcity]){
                   visited [nextcity]=true;
                   q.add(nextcity);
                }
            }
        }
        return min; 
    }
}