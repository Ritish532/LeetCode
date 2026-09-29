class Solution {
    Boolean dp[][][];
    public boolean hasValidPath(char[][] grid) {
        int n = grid.length , m = grid[0].length;
        if(grid[n-1][m-1] == '(' || (n+m-1) % 2 != 0) return false;
        dp = new Boolean[n][m][n+m-1];
        return dfs(grid , n-1 , m-1 , 1);
    }
    public boolean dfs(char[][] grid , int i , int j , int balance){
        if(balance < 0) return false;
        if(i == 0 && j == 0){
            return balance == 0;
        }
        if(dp[i][j][balance] != null) return dp[i][j][balance];
        if(i > 0){
            char ch = grid[i-1][j];
            if(ch == ')'){
                if(dfs(grid , i-1 , j , balance+1)) return dp[i][j][balance] = true;
            }
            else{
                if(dfs(grid , i-1 , j , balance-1)) return dp[i][j][balance] = true;
            }
        }
        if(j > 0){
            char ch = grid[i][j-1];
            if(ch == ')'){
                if(dfs(grid , i , j-1 , balance+1)) return dp[i][j][balance] = true;
            }
            else{
                if(dfs(grid , i , j-1 , balance-1)) return dp[i][j][balance] = true;
            }
        }
        return dp[i][j][balance] = false;
    }
}