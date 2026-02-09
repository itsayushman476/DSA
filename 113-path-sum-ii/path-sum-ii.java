class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        solve(root, targetSum, new ArrayList<>());
        return ans;
    }
    void solve(TreeNode root, int sum, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            ans.add(new ArrayList<>(path));
        }
        solve(root.left, sum, path);
        solve(root.right, sum, path);
        path.remove(path.size() - 1);
    }
}
