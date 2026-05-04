/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return solve(root,0);
    }
    public int solve(TreeNode node,int current){
        if(node==null) return 0;
        current=current*10+node.val;
        if(node.left==null && node.right==null){
            return current;
        }
        return solve(node.left,current)+solve(node.right,current);
    }
}