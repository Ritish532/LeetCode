class Solution {
    public long Chck(int i , int[] coins ,int amount , long[][] dp){
        if(i == coins.length){
            if(0 == amount) return 0;
            return Integer.MAX_VALUE;
        }
        if(dp[i][amount] != -1) return dp[i][amount];
        long skip = Chck(i+1 , coins , amount , dp);
        if(amount-coins[i] < 0) return dp[i][amount] = skip;
        long pick = 1 + Chck(i , coins , amount-coins[i] , dp);  
        return  dp[i][amount] = Math.min(pick , skip);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length; 
        long[][] dp = new long[n][amount+1];
        for(long[] row : dp) Arrays.fill(row,-1);
        dp[n-1][amount] = Chck(0,coins,amount,dp);
        return (dp[n-1][amount] == Integer.MAX_VALUE)? -1 : (int) dp[n-1][amount];
    }
}