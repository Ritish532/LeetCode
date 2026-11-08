class Solution {
    public int dfs(int grid[][] , int i,  int j , boolean[][] vis){
        vis[i][j] = true;
        int count  = 1;
        for(int k = 0 ; k < grid.length ; k++){
            if(grid[k][j] == 1 && !vis[k][j]){
                count += dfs(grid , k , j , vis);
            }
        }
        for(int k = 0 ; k < grid[0].length ; k++){
            if(grid[i][k] == 1 && !vis[i][k]){
                count += dfs(grid , i , k , vis);
            }
        }
        return count;
    }
    public int countServers(int[][] grid) {
        int count = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    vis[i][j] = true;
                    int a = dfs(grid , i , j , vis);
                    if(a > 1) count += a;
                }
            }
        }
        return count;
    }
}