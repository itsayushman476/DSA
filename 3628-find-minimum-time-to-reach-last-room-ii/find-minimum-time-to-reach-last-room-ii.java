import java.util.*;

class Solution {
    public int minTimeToReach(int[][] moveTime) {

        int m = moveTime.length;
        int n = moveTime[0].length;

        int[][] dist = new int[m][n];
        for(int[] row : dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        pq.offer(new int[]{0,0,0}); // time,row,col
        dist[0][0] = 0;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!pq.isEmpty()){

            int[] cur = pq.poll();
            int time = cur[0];
            int r = cur[1];
            int c = cur[2];

            if(r == m-1 && c == n-1) return time;

            for(int[] d : dir){

                int nr = r + d[0];
                int nc = c + d[1];

                if(nr<0 || nc<0 || nr>=m || nc>=n) continue;

                int moveCost = ((r + c) % 2 == 0) ? 1 : 2;

                int newTime = Math.max(time, moveTime[nr][nc]) + moveCost;

                if(newTime < dist[nr][nc]){
                    dist[nr][nc] = newTime;
                    pq.offer(new int[]{newTime,nr,nc});
                }
            }
        }

        return -1;
    }
}