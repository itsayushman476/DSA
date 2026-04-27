import java.util.*;
class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dirs = {
            {}, 
            {{0,-1}, {0,1}},     
            {{-1,0}, {1,0}},     
            {{0,-1}, {1,0}},    
            {{0,1}, {1,0}},     
            {{0,-1}, {-1,0}},   
            {{0,1}, {-1,0}}    
        };
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            if (r == m - 1 && c == n - 1) return true;
            for (int[] d : dirs[grid[r][c]]) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    for (int[] back : dirs[grid[nr][nc]]) {
                        if (back[0] == -d[0] && back[1] == -d[1]) {
                            visited[nr][nc] = true;
                            queue.offer(new int[]{nr, nc});
                            break;
                        }
                    }
                }
            }
        }
        return false;
    }
}