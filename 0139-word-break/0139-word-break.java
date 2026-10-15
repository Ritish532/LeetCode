class Solution {
    public boolean dfs(int i , String s , Set<String> set , String a , Boolean[] dp){
        if(i == s.length()) return true;
        if(dp[i] != null) return dp[i];
        for(int j = i ; j < s.length() ; j++){
            a = s.substring(i , j+1);
            if(set.contains(a)){
                if(dfs(j+1 , s , set , a , dp)) return dp[i] = true;
            }
        }
        return dp[i] = false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>();
        Boolean[] dp = new Boolean[s.length()];
        for(String f : wordDict) set.add(f);
        return dfs(0 , s , set , "" , dp);
    }

}