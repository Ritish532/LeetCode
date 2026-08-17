class Solution {
    public int dfs(int i , int j, int n , int m , int[][] grid){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        return 1 + dfs(i+1 , j ,  n , m , grid) + dfs(i-1 , j ,  n , m , grid) + dfs(i , j+1 ,  n , m , grid) + dfs(i , j-1 , n , m , grid);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int count = 0 , n = grid.length , m = grid[0].length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    count = Math.max(dfs(i , j , n , m , grid) , count);
                }
            }
        }
        return count;
    }
}