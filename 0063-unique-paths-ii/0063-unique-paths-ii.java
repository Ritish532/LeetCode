//Memoization
class Solution {
    public int Paths(int row , int col , Integer m, Integer n , int[][] dp , int[][] grid) {
        if(row >= m || col >= n) return 0;
        if(row == m-1 && col == n-1) return 1;
        if(grid[row][col] == 1) return 0;
        if(dp[row][col] != -1) return dp[row][col];
        return dp[row][col] = Paths(row+1 , col , m , n , dp , grid) + Paths(row , col+1 , m , n , dp , grid);
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        if(grid[m-1][n-1] == 1) return 0;
        int[][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row,-1);
        return Paths(0 , 0 , m , n , dp , grid);
    }
}
