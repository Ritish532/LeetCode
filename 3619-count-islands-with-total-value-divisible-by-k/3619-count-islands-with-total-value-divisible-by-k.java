class Solution {
    public long dfs(int i , int j , int[][] grid , boolean[][] vis){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return 0;
        if(grid[i][j] == 0) return 0;
        if(vis[i][j]) return 0;
        vis[i][j] = true;
        return grid[i][j] + dfs(i+1 , j , grid , vis) + dfs(i-1 , j , grid , vis) + dfs(i , j-1 , grid , vis) + dfs(i , j+1 , grid , vis);
    }
    public int countIslands(int[][] grid, int k) {
        int count = 0 , n = grid.length , m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] != 0 && !vis[i][j]){
                    if(dfs(i , j , grid , vis) % k == 0) count++;
                }
            }
        }
        return count;
    }
}