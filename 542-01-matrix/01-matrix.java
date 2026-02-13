class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                } else{
                    mat[i][j]=-1;
                }
            }
        }
        int dir[][]={{1,0},{-1,0},{0,1},{0,-1}};
        while(q.size()>0){
            int cell[]=q.remove();
            int r=cell[0];
            int c=cell[1];
            for(int []d:dir){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr>=0 && nc>=0 && nr<m && nc<n && mat[nr][nc]==-1){
                    mat[nr][nc]=1+mat[r][c];
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return mat;
    }
}