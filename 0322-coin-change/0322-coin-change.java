class Solution {
    public int Chck(int i , int[] coins ,int amount , int[][] dp){
        if(i == coins.length){
            if(0 == amount) return 0;
            return Integer.MAX_VALUE-1;
        }
        if(dp[i][amount] != -1) return dp[i][amount];
        int skip = Chck(i+1 , coins , amount , dp);
        int pick = Integer.MAX_VALUE -1;
        if(amount-coins[i] < 0) dp[i][amount] = skip;
        else pick = 1 + Chck(i , coins , amount-coins[i] , dp);  
        return  dp[i][amount] = Math.min(pick , skip);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length; 
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        dp[n-1][amount] = Chck(0,coins,amount,dp);
        return (dp[n-1][amount] == Integer.MAX_VALUE -1 )? -1 : dp[n-1][amount];
    }
}