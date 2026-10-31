class Solution {
    public long[][][] dp;
    public long dfs(int i , int j , int[][] grid , int move){
        if(i == grid.length-1 && j == grid[0].length-1){
            return 1;
        }
        if(i >= grid.length || j >= grid[0].length) return 0;
        if(dp[i][j][move] != -1) return dp[i][j][move];
        if(grid[i][j] == 1){
            if(move == 1) return dp[i][j][move] = dfs(i , j+1 , grid , 0);
            else return dp[i][j][move] = dfs(i+1 , j , grid , 1);
        }
        long MOD = 1000000007L;
        long down = dfs(i+1 , j , grid , 1) ;
        long right = dfs(i , j+1 , grid , 0);
        return dp[i][j][move] = (down + right) % MOD ;
        
    }
    public int uniquePaths(int[][] grid) {
        dp = new long[grid.length][grid[0].length][2];
        for(long[][] rows : dp) for(long[] row : rows) Arrays.fill(row,-1);
        return (int) dfs(0 , 0 , grid , 0);
    }
}
// 0 -> moved right
// 1 -> moved down