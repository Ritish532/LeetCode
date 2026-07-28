class Solution {
    public int helper(int i , int j ,  StringBuilder a , StringBuilder b , int[][] dp){
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(a.charAt(i) == b.charAt(j)) return dp[i][j] = 1 + helper(i-1 , j-1 , a , b , dp);
        else return dp[i][j] = Math.max(helper(i , j-1 , a , b , dp) , helper(i-1 , j , a , b , dp));
    }
    public int minDistance(String word1, String word2) {
        StringBuilder a = new StringBuilder(word1);
        StringBuilder b = new StringBuilder(word2);
        int[][] dp = new int[a.length()][b.length()];
        for(int[] row : dp) Arrays.fill(row , -1);
        return ((a.length() + b.length()) - (helper(a.length()-1 , b.length()-1 , a , b , dp)*2));
    }
}