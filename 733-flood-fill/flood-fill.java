class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int oldcolor = image[sr][sc];
        if(oldcolor == color) return image;      
        dfs(image, sr, sc, oldcolor, color);
        return image;
    }
    public void dfs(int[][] image, int sr, int sc,
                    int oldcolor, int newcolor){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length
           || image[sr][sc] != oldcolor) return;
        image[sr][sc] = newcolor;   
        dfs(image, sr+1, sc, oldcolor, newcolor);
        dfs(image, sr-1, sc, oldcolor, newcolor);
        dfs(image, sr, sc+1, oldcolor, newcolor);
        dfs(image, sr, sc-1, oldcolor, newcolor);
    }
}
