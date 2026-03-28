class Solution {
    int[][] dp;
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return solve(0, 1, prices, fee);
    }
    public int solve(int i, int canBuy, int[] prices, int fee) {
        if (i == prices.length)
            return 0;
        if (dp[i][canBuy] != -1)
            return dp[i][canBuy];
        int profit;
        if (canBuy == 1) {
            int buy = -prices[i] + solve(i + 1, 0, prices, fee);
            int skip = solve(i + 1, 1, prices, fee);
            profit = Math.max(buy, skip);
        } else {
            int sell = prices[i] - fee + solve(i + 1, 1, prices, fee);
            int skip = solve(i + 1, 0, prices, fee);
            profit = Math.max(sell, skip);
        }
        return dp[i][canBuy] = profit;
    }
}