class Solution {
    public int knightDialer(int n) {
        int MOD = 1000000007;
        long[] dp = new long[10];
        for(int i = 0; i < 10; i++) dp[i] = 1;
        for(int step = 1; step < n; step++) {
            long[] next = new long[10];
            next[0] = (dp[4] + dp[6]) % MOD;
            next[1] = (dp[6] + dp[8]) % MOD;
            next[2] = (dp[7] + dp[9]) % MOD;
            next[3] = (dp[4] + dp[8]) % MOD;
            next[4] = (dp[0] + dp[3] + dp[9]) % MOD;
            next[5] = 0;
            next[6] = (dp[0] + dp[1] + dp[7]) % MOD;
            next[7] = (dp[2] + dp[6]) % MOD;
            next[8] = (dp[1] + dp[3]) % MOD;
            next[9] = (dp[2] + dp[4]) % MOD;

            dp = next;
        }
        long ans = 0;
        for(long x : dp) ans = (ans + x) % MOD;
        return (int) ans;
    }
}