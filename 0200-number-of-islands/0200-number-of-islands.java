class Solution {
    public void dfs(int i , int j , int n , int m , char[][] grid , boolean[][] vis){
        if(i < 0 || j < 0 || i >= n  || j >= m || grid[i][j] != '1' || vis[i][j]) return;
        vis[i][j] = true;
        dfs(i+1 , j , n , m , grid , vis);
        dfs(i-1 , j , n , m , grid , vis);
        dfs(i , j-1 , n , m , grid , vis);
        dfs(i , j+1 , n , m , grid , vis);
    }
    public int numIslands(char[][] grid) {
        int count = 0 , n = grid.length , m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    dfs(i , j , n , m , grid , vis);
                    count++;
                }
            }
        }
        return count;
    }
}
