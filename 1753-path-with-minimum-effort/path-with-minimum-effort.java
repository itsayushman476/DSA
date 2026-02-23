class Solution {
    class Pair {
        int r, c, effort;
        Pair(int r,int c,int effort){
            this.r = r;
            this.c = c;
            this.effort = effort;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a,b)->a.effort - b.effort);
        pq.add(new Pair(0,0,0));
        dist[0][0] = 0;
        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            int r = cur.r;
            int c = cur.c;
            int effort = cur.effort;
            if(r==n-1 && c==m-1) return effort;
            //  UP
            if(r-1 >= 0){
                int diff = Math.abs(heights[r][c] - heights[r-1][c]);
                int newEffort = Math.max(effort, diff);
                if(newEffort < dist[r-1][c]){
                    dist[r-1][c] = newEffort;
                    pq.add(new Pair(r-1,c,newEffort));
                }
            }
            //  RIGHT
            if(c+1 < m){
                int diff = Math.abs(heights[r][c] - heights[r][c+1]);
                int newEffort = Math.max(effort, diff);
                if(newEffort < dist[r][c+1]){
                    dist[r][c+1] = newEffort;
                    pq.add(new Pair(r,c+1,newEffort));
                }
            }
            //  DOWN
            if(r+1 < n){
                int diff = Math.abs(heights[r][c] - heights[r+1][c]);
                int newEffort = Math.max(effort, diff);
                if(newEffort < dist[r+1][c]){
                    dist[r+1][c] = newEffort;
                    pq.add(new Pair(r+1,c,newEffort));
                }
            }
            //  LEFT
            if(c-1 >= 0){
                int diff = Math.abs(heights[r][c] - heights[r][c-1]);
                int newEffort = Math.max(effort, diff);
                if(newEffort < dist[r][c-1]){
                    dist[r][c-1] = newEffort;
                    pq.add(new Pair(r,c-1,newEffort));
                }
            }
        }
        return 0;
    }
}