import java.util.*;
class Solution {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Collections.sort(offers, (a, b) -> a.get(0) - b.get(0));
        int m = offers.size();
        int[] starts = new int[m];
        for (int i = 0; i < m; i++) {
            starts[i] = offers.get(i).get(0);
        }
        Integer[] dp = new Integer[m];
        return solve(offers, starts, 0, dp);
    }  
    private int solve(List<List<Integer>> offers, int[] starts, int i, Integer[] dp) {
        if (i >= offers.size()) return 0;
        if (dp[i] != null) return dp[i];
        int skip = solve(offers, starts, i + 1, dp);
        int start = offers.get(i).get(0);
        int end = offers.get(i).get(1);
        int gold = offers.get(i).get(2);
        int nextIndex = binarySearch(starts, end + 1);
        int take = gold + solve(offers, starts, nextIndex, dp);
        return dp[i] = Math.max(skip, take);
    }
    private int binarySearch(int[] starts, int target) {
        int left = 0, right = starts.length - 1;
        int ans = starts.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (starts[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}