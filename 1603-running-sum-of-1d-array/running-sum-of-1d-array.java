class Solution {
    public int[] runningSum(int[] nums) {
        int n=nums.length;
        int result[]=new int[n];
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<=i;j++){
                sum=sum+nums[j];
            }
            result[i]=sum;
        }
        return result;  
    }
}