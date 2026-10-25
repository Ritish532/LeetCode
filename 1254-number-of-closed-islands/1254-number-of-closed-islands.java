class Solution {
    public boolean flag ;
    public void dfs(int i , int j , int[][] grid , boolean[][] vis){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            flag = true;
            return;
        }
        if(grid[i][j] == 1){
            return;
        }
        if(vis[i][j]) return;
        vis[i][j] = true;
        dfs(i-1 , j , grid , vis);
        dfs(i+1 , j , grid , vis);
        dfs(i , j-1 , grid , vis);
        dfs(i , j+1 , grid , vis);
        return;
    }
    public int closedIsland(int[][] grid) {
        int n = grid.length , m = grid[0].length , count = 0;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 0 && !vis[i][j]){
                    flag = false;
                    dfs(i , j , grid , vis);
                    if(!flag) count++;
                }
            }
        }
        return count;
    }
}