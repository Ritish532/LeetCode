class Solution {
    public boolean checkValidString(String s) {
        int n  = s.length();
        Boolean[][] dp = new Boolean[n][n+1];
        return solve(s , 0 , 0 , dp);
    }
    public boolean solve(String s , int i , int balance , Boolean[][] dp){
        if(balance < 0) return false;
        if(i == s.length()) return balance == 0;
        if(dp[i][balance] != null) return dp[i][balance];
        char ch = s.charAt(i);
        if(ch == '(') return dp[i][balance] = solve(s , i+1 , balance+1 , dp);
        else if(ch == ')') return dp[i][balance] = solve(s , i+1 , balance-1 , dp);
        else return dp[i][balance] = solve(s , i+1 , balance+1 , dp) || solve(s , i+1 , balance-1 , dp) || solve(s , i+1 , balance , dp);
    }
}