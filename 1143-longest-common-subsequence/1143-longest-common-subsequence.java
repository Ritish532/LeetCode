class Solution {
    public int lcs(int n , int m , StringBuilder a, StringBuilder b , int[][] dp){
        if(n < 0 || m < 0) return 0;
        if(dp[n][m] != -1) return dp[n][m];
        if(a.charAt(n) == b.charAt(m)){
            return dp[n][m] = 1 + lcs(n-1 , m-1 , a , b , dp);
        }
        else{
            dp[n][m] = Math.max(lcs(n , m-1 , a , b , dp) , lcs(n-1 , m , a , b , dp));
        }
        return dp[n][m];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length() , m = text2.length();
        StringBuilder a = new StringBuilder(text1);
        StringBuilder b = new StringBuilder(text2);
        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row , -1);
        return lcs(n-1 , m-1 , a , b , dp);
    }
}