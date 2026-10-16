class Solution {
    public int nthUglyNumber(int n) {
        int a  = 0 , b = 0 , c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1 ; i < n ; i++){
            int x = dp[a] * 2;
            int y = dp[b] * 3;
            int z = dp[c] * 5;

            dp[i] = Math.min(x , Math.min(y,z));
            if(dp[i] == x) a++;
            if(dp[i] == y) b++;
            if(dp[i] == z) c++;
        }
        return dp[n-1];
    }
}