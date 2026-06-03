import java.util.*;

class Solution {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        long ans1 = solve(landStartTime, landDuration,
                          waterStartTime, waterDuration);

        long ans2 = solve(waterStartTime, waterDuration,
                          landStartTime, landDuration);

        return (int) Math.min(ans1, ans2);
    }

    private long solve(int[] firstStart, int[] firstDur,
                       int[] secondStart, int[] secondDur) {

        int m = secondStart.length;

        int[][] rides = new int[m][2];
        for (int i = 0; i < m; i++) {
            rides[i][0] = secondStart[i];
            rides[i][1] = secondDur[i];
        }

        Arrays.sort(rides, (a, b) -> Integer.compare(a[0], b[0]));

        int[] starts = new int[m];
        long[] prefMinDur = new long[m];
        long[] sufMinEnd = new long[m];

        starts[0] = rides[0][0];
        prefMinDur[0] = rides[0][1];

        for (int i = 1; i < m; i++) {
            starts[i] = rides[i][0];
            prefMinDur[i] = Math.min(prefMinDur[i - 1], rides[i][1]);
        }

        sufMinEnd[m - 1] = (long) rides[m - 1][0] + rides[m - 1][1];

        for (int i = m - 2; i >= 0; i--) {
            sufMinEnd[i] = Math.min(
                sufMinEnd[i + 1],
                (long) rides[i][0] + rides[i][1]
            );
        }

        long ans = Long.MAX_VALUE;

        for (int i = 0; i < firstStart.length; i++) {

            long t = (long) firstStart[i] + firstDur[i];

            int k = upperBound(starts, (int) t);

            long best = Long.MAX_VALUE;

            // start <= t
            if (k > 0) {
                best = Math.min(best, t + prefMinDur[k - 1]);
            }

            // start > t
            if (k < m) {
                best = Math.min(best, sufMinEnd[k]);
            }

            ans = Math.min(ans, best);
        }

        return ans;
    }

    private int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}