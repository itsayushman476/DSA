import java.util.*;

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;

        int[][][] dist = new int[m][n][2];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a,b)->a[0]-b[0]);

        pq.add(new int[]{0,0,0,0}); // time,row,col,parity
        dist[0][0][0] = 0;

        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};

        while(!pq.isEmpty()){

            int[] cur=pq.poll();
            int time=cur[0];
            int r=cur[1];
            int c=cur[2];
            int parity=cur[3];

            if(r==m-1 && c==n-1) return time;

            for(int[] d:dir){

                int nr=r+d[0];
                int nc=c+d[1];

                if(nr<0||nc<0||nr>=m||nc>=n) continue;

                int moveCost = (parity==0)?1:2;

                int newTime = Math.max(time,moveTime[nr][nc]) + moveCost;

                int newParity = 1-parity;

                if(newTime < dist[nr][nc][newParity]){

                    dist[nr][nc][newParity] = newTime;

                    pq.offer(new int[]{newTime,nr,nc,newParity});
                }
            }
        }

        return -1;
    }
}