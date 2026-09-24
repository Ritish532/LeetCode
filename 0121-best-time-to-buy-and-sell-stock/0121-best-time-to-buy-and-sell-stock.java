class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n < 2) return 0;

        int max_p = 0 , max_r = prices[n-1];

        for(int i = n-2 ; i >= 0 ; i--){
           max_p = Math.max(max_p , max_r - prices[i]);
           max_r = Math.max(max_r , prices[i]);
        }
        return max_p;
    }
}

