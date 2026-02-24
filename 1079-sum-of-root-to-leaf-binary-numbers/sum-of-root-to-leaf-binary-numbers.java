class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root,"");
    }
    public int dfs(TreeNode node, String path){
        if(node==null ) return 0;
        path=path+node.val;
        if(node.left==null && node.right==null){
            return Integer.parseInt(path,2);
        }
        return dfs(node.left,path)+dfs(node.right,path);
    }
}