class Solution {
    public int dfs(int i , int j , int n , int m , int[][] grid){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0) return 0;
        int fish = grid[i][j];
        grid[i][j] = 0;
        fish += dfs(i+1 , j , n , m , grid);
        fish += dfs(i-1 , j , n , m , grid);
        fish += dfs(i , j+1 , n , m , grid);
        fish += dfs(i , j-1 , n , m , grid);
        return fish;
    }
    public int findMaxFish(int[][] grid) {
        int n = grid.length , m = grid[0].length , ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j  <m ; j++){
                if(grid[i][j] > 0){
                    ans = Math.max(ans , dfs(i , j , n , m , grid));
                }
            }
        }
        return ans;
    }
}