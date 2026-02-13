class Solution {
    int m, n;
    int count;   
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[][] visited = new int[m][n];
        int max = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    count = 0;         
                    dfs(grid, visited, i, j);   
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }

    public void dfs(int[][] grid, int[][] visited, int i, int j){
        if(i < 0 || j < 0 || i >= m || j >= n 
           || grid[i][j] == 0 || visited[i][j] == 1){
            return;
        }

        visited[i][j] = 1;
        count++;                 

        dfs(grid, visited, i-1, j);
        dfs(grid, visited, i+1, j);
        dfs(grid, visited, i, j-1);
        dfs(grid, visited, i, j+1);
    }
}

