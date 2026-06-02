class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int minsum=0;
        int maxsum=0;
        int n=nums.length;
        for(int i=0;i<k;i++){
            minsum=minsum+nums[i];
            maxsum=maxsum+nums[n-1-i];
        }
        return Math.abs(minsum-maxsum);
    }
}