class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        helper(nums,0,result);
        return result;
    }
    public void helper(int []nums,int start, List<List<Integer>> result){
        if(start==nums.length){
            List<Integer> arr=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                arr.add(nums[i]);
            }
            result.add(arr);
                return;
        }
        for(int i=start;i<nums.length;i++){
            swap(nums,start,i);
            helper(nums,start+1,result);
            swap(nums,start,i);
        }
    }
    public void swap(int nums[],int i,int j){
        int temp=nums[i];
        nums [i]=nums [j];
        nums [j]=temp;
    }
}