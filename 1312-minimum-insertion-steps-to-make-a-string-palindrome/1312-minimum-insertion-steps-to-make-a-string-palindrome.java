class Solution {
    public int LCS(int n , int m , StringBuilder a  , StringBuilder b , int[][] dp){
        if(n < 0 || m < 0) return 0;
        if(dp[n][m] != -1) return dp[n][m];
        if(a.charAt(n) == b.charAt(m)){
            return dp[n][m] = 1 + LCS(n-1,m-1,a,b,dp);
        }
        else{
            return dp[n][m] = Math.max(LCS(n-1,m,a,b,dp) , LCS(n,m-1,a,b,dp));
        }
    }
    public int minInsertions(String s) {
        StringBuilder a = new StringBuilder(s);
        StringBuilder b = new StringBuilder(s).reverse();
        int n = a.length();
        int[][] dp = new int[n][n];
        for(int[] row : dp) Arrays.fill(row,-1);
        return n - LCS(n-1,n-1,a,b,dp);
    }
}
