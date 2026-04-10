class Solution {
    public int path(int m , int n , int[][] grid, int[][] dp) {
        if(m >= grid.length || n >= grid[0].length) return Integer.MAX_VALUE;
        if(m == grid.length-1 && n == grid[0].length-1) return grid[m][n];
        if(dp[m][n] != -1) return dp[m][n];
        int down = path(m+1 , n , grid , dp);
        int ryt = path(m , n+1 , grid , dp);
        return dp[m][n] = grid[m][n] + Math.min(down,ryt);
    }
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] row : dp) Arrays.fill(row,-1);
        return path(0 , 0 , grid , dp);
    }
}