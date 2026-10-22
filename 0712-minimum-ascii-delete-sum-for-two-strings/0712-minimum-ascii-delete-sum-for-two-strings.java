class Solution {
    public int dfs(String s1 , String s2 , int i , int j , int[][] dp){
        if(i == s1.length()){
            int sum = 0;
            while(j < s2.length()) sum += (int) s2.charAt(j++);
            return sum;
        }
        if(j == s2.length()){
            int sum = 0;
            while(i < s1.length()) sum += (int) s1.charAt(i++);
            return sum;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = dfs(s1, s2 , i+1 , j+1 , dp);

        int dels1 = (int) s1.charAt(i) + dfs(s1 , s2 , i+1 , j , dp);
        int dels2 = (int) s2.charAt(j) + dfs(s1 , s2 , i , j+1 , dp);
        return dp[i][j] = Math.min(dels1 , dels2);
    }
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for(int[] row : dp) Arrays.fill(row , -1);
        return dfs(s1 , s2 , 0 , 0 , dp);
    }
}