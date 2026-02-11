import java.util.*;
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, result);
        return result;
    }
    public void helper(int[] nums, int start, List<List<Integer>> result){
        if(start == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int n : nums) list.add(n);
            result.add(list);
            return;
        }
        HashSet<Integer> used = new HashSet<>();   
        for(int i = start; i < nums.length; i++){
            if(used.contains(nums[i])) continue;  
            used.add(nums[i]);
            swap(nums, start, i);
            helper(nums, start + 1, result);
            swap(nums, start, i);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
