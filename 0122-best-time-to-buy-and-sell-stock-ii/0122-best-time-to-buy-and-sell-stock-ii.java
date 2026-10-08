class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0 , n = prices.length;
        for(int i = 1 ; i < n ; i++){
            int x = prices[i] - prices[i-1];
            ans += (x < 0)? 0 : x;
        }
        return ans;
    }
}