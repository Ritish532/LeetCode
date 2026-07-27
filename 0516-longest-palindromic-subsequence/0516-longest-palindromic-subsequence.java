class Solution {
    public int LCS(int i , int j ,  StringBuilder a , StringBuilder b , int[][] dp){
        if(i < 0 || j < 0) return 0;
        // if(i == 0 && j != 0 || i != 0 && j == 0) return -1;
        if(dp[i][j] != -1) return dp[i][j];
        if(a.charAt(i) == b.charAt(j)) return dp[i][j] = 1 + LCS(i-1,j-1,a,b,dp);
        else return dp[i][j] = Math.max(LCS(i,j-1,a,b,dp) , LCS(i-1,j,a,b,dp));
    }
    public int longestPalindromeSubseq(String s) {
        StringBuilder s1 = new StringBuilder(s);
        StringBuilder s2 = new StringBuilder(s).reverse();
        int n = s1.length();
        int[][] dp = new int[n][n];
        for(int[] row : dp) Arrays.fill(row ,-1);
        return LCS(n-1,n-1,s1,s2,dp);
    }
}

// class Solution {
//     public int lcs(int n , int m , StringBuilder a, StringBuilder b , int[][] dp){
//         if(n < 0 || m < 0) return 0;
//         if(dp[n][m] != -1) return dp[n][m];
//         if(a.charAt(n) == b.charAt(m)){
//             return dp[n][m] = 1 + lcs(n-1 , m-1 , a , b , dp);
//         }
//         else{
//             dp[n][m] = Math.max(lcs(n , m-1 , a , b , dp) , lcs(n-1 , m , a , b , dp));
//         }
//         return dp[n][m];
//     }

//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length() , m = text2.length();
//         StringBuilder a = new StringBuilder(text1);
//         StringBuilder b = new StringBuilder(text2);
//         int[][] dp = new int[n][m];
//         for(int[] row : dp) Arrays.fill(row , -1);
//         return lcs(n-1 , m-1 , a , b , dp);
//     }
// }