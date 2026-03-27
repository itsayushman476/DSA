class Solution {
    int MOD = 1000000007;
    int[][] dp;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        dp = new int[n][fuel + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(start, fuel, locations, finish);
    }
    private int solve(int i, int fuel, int[] loc, int finish) {
        if (fuel < 0) return 0;
        if (dp[i][fuel] != -1) return dp[i][fuel];
        int count = 0;
        if (i == finish) count = 1;
        for (int j = 0; j < loc.length; j++) {
            if (i == j) continue;
            int cost = Math.abs(loc[i] - loc[j]);
            if (fuel >= cost) {
                count = (count + solve(j, fuel - cost, loc, finish)) % 1000000007;
            }
        }
        return dp[i][fuel] = count;
    }
}