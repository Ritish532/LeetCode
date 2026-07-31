class Solution {
    public int solve(int i , int j , int n , List<List<Integer>> arr , Integer[][] dp){
        if(i == n-1) return arr.get(i).get(j);
        if(dp[i][j] != null) return dp[i][j];
        int down = solve(i+1 , j , n , arr , dp);
        int downRyt = solve(i+1 , j+1 , n , arr , dp);
        return dp[i][j] = arr.get(i).get(j) + Math.min(down , downRyt);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];
        return solve(0 , 0 , n , triangle , dp);
    }
}