class Solution {
    public int dfs(int i , int n , String s , int[] dp){
        if(i == n) return 1;
        if(s.charAt(i) == '0') return 0;
        if(dp[i] != -1) return dp[i];
        int takeOne = dfs(i+1 , n , s , dp);
        int takeTwo = 0;
        if(i+1 < n){
            // String a = "" + s.charAt(i) + s.charAt(i+1);
            int num = Integer.parseInt(s.substring(i,i+2));
            if(num >= 10 && num <= 26) takeTwo = dfs(i+2 , n , s , dp);
        }
        return dp[i] = takeOne + takeTwo;
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return dfs(0 , n , s , dp);
    }
}