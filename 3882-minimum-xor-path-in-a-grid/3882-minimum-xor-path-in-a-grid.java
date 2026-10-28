class Solution {
    public int ans;
    public void dfs(int i , int j , int xor , int[][] grid , boolean[][][] dp){
        if(i >= grid.length || j >= grid[0].length) return;
        if(i == grid.length-1 && j == grid[0].length-1){
            ans = Math.min(ans ,grid[i][j] ^ xor);
            return;
        }
        if(dp[i][j][xor]) return;
        dp[i][j][xor] = true;
        if(i < grid.length) dfs(i+1 , j , xor ^ grid[i][j] , grid , dp);
        if(j < grid[0].length) dfs(i , j+1 , xor ^ grid[i][j] , grid , dp);
    }
    public int minCost(int[][] grid) {
        ans = Integer.MAX_VALUE;
        boolean[][][] dp = new boolean[grid.length][grid[0].length][1024];
        dfs(0 , 0 , 0 , grid , dp);
        return ans;
    }
}