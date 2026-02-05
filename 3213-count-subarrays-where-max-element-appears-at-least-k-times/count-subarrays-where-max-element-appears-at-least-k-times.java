class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxValue = Integer.MIN_VALUE;
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }
        long ans = 0;
        int i = 0;
        int maxCount = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == maxValue) {
                maxCount++;
            }
            while (maxCount >= k) {
                ans += nums.length - j;
                if (nums[i] == maxValue) {
                    maxCount--;
                }
                i++;
            }
        }
        return ans;
    }
}
