class Solution {
    public int dfs(int[] prices , int fee , int i , int canBuy , int[][] dp){
        if(i == prices.length) return 0;
        if(dp[i][canBuy] != -1) return dp[i][canBuy];
        int take = 0 , skip = 0;
        if(canBuy == 0){
            take = -prices[i] - fee + dfs(prices , fee , i+1 , 1 , dp);
            skip = dfs(prices , fee , i+1 , canBuy , dp);
        }
        else{
            take = prices[i] + dfs(prices , fee , i+1 , 0 , dp);
            skip = dfs(prices , fee , i+1 , canBuy , dp);
        }
        return dp[i][canBuy] = Math.max(take , skip);
    }
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for(int[] row : dp) Arrays.fill(row , -1);
        return dfs(prices , fee , 0 , 0 , dp);
    }
}
// 0 -> have to buy
// 1 -> have to sell