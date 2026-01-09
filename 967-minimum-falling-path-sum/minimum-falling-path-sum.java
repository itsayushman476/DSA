class Solution {
    int[][] dp;
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        dp = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        int ans = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            ans = Math.min(ans, solve(0, col, matrix));
        }
        return ans;
    }
    int solve(int i, int j, int[][] mat) {
         if (j < 0 || j >= mat.length) return 100000;
        if (i == mat.length - 1) return mat[i][j];
        if (dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];
        int down = solve(i + 1, j, mat);
        int left = solve(i + 1, j - 1, mat);
        int right = solve(i + 1, j + 1, mat);
        return dp[i][j] = mat[i][j] + Math.min(down, Math.min(left, right));
    }
}

