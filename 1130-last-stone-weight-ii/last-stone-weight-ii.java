class Solution {
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for (int x : stones) total += x;
        int[][] dp = new int[stones.length][total + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = 0; j <= total; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(stones, 0, 0, total, dp);
    }
    public int helper(int[] stones, int i, int s1, int total, int[][] dp) {
        if (i == stones.length) {
            return Math.abs(s1 - (total - s1));
        }
        if (dp[i][s1] != -1) return dp[i][s1];
        int take = helper(stones, i + 1, s1 + stones[i], total, dp);
        int skip = helper(stones, i + 1, s1, total, dp);
        return dp[i][s1] = Math.min(take, skip);
    }
}