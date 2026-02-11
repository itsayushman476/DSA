import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(candidates, 0, target, result, list);
        return result;
    }
    public void helper(int[] nums, int idx, int target,
                       List<List<Integer>> result,
                       List<Integer> list) {
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(idx == nums.length || target < 0) return;
        list.add(nums[idx]);
        helper(nums, idx, target - nums[idx], result, list);
        list.remove(list.size() - 1);
        helper(nums, idx + 1, target, result, list);
    }
}
