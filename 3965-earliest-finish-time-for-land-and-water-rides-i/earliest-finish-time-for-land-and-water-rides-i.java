class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {
        int ans = Math.min(
            solve(landStartTime, landDuration, waterStartTime, waterDuration),
            solve(waterStartTime, waterDuration, landStartTime, landDuration)
        );
        return ans;
    }
    private int solve(int[] start1, int[] dur1,
                      int[] start2, int[] dur2) {
        int minEnd = Integer.MAX_VALUE;
        for (int i = 0; i < start1.length; i++) {
            minEnd = Math.min(minEnd, start1[i] + dur1[i]);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < start2.length; i++) {
            res = Math.min(res,
                    Math.max(minEnd, start2[i]) + dur2[i]);
        }
        return res;
    }
}