class Solution {
    public int tribonacci(int n , int[] dp) {
        if(n <= 0) return 0;
        if(n <= 2) return 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = tribonacci(n-1 , dp) + tribonacci(n-2 , dp) + tribonacci(n-3 , dp);
    }

    public int tribonacci(int n){
        if(n <= 1) return n;
        if(n == 2) return 1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp,-1);
        tribonacci(n , dp);
        return dp[n];
     }
}