class Solution {
    class pair {
        int row;
        int col;
        pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean vis[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && vis[i][j] == false) {
                    bfs(i, j, grid, vis);
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(int i, int j, char grid[][], boolean vis[][]) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(i, j));
        vis[i][j] = true;
        while (q.size() > 0) {
            pair front = q.remove();
            int row = front.row;
            int col = front.col;
            if (row > 0) {
                if (vis[row - 1][col] == false && grid[row - 1][col] == '1') {
                    q.add(new pair(row - 1, col));
                    vis[row - 1][col] = true;
                }
            }
            if (row < m - 1) {
                if (vis[row + 1][col] == false && grid[row + 1][col] == '1') {
                    q.add(new pair(row + 1, col));
                    vis[row + 1][col] = true;
                }
            }
            if (col > 0) {
                if (vis[row][col - 1] == false && grid[row][col - 1] == '1') {
                    q.add(new pair(row, col - 1));
                    vis[row][col - 1] = true;
                }
            }
            if (col < n - 1) {
                if (vis[row][col + 1] == false && grid[row][col + 1] == '1') {
                    q.add(new pair(row, col + 1));
                    vis[row][col + 1] = true;
                }
            }
        }
    }
}
