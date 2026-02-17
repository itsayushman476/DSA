import java.util.*;
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int time = 0;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int size = q.size();
            boolean changed = false;
            for(int i=0;i<size;i++){
                int[] front = q.poll();
                for(int[] d : dir){
                    int r = front[0] + d[0];
                    int c = front[1] + d[1];
                    if(r>=0 && c>=0 && r<m && c<n && grid[r][c]==1){
                        grid[r][c]=2;
                        fresh--;
                        changed = true;
                        q.add(new int[]{r,c});
                    }
                }
            }
            if(changed){
                time++;
            }
        }
        if(fresh==0){
            return time;
        }else{
            return -1;
        }
    }
}
