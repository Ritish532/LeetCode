class Solution {
    public boolean dfs(HashMap<Integer , Integer> map , int[] stones , int i , int k , Boolean[][] dp){
        if(i == stones.length-1) return true;
        if(dp[i][k] != null) return dp[i][k];
        if(k-1 > 0 && map.containsKey(stones[i] + (k-1))){
            int index = map.get(stones[i] + (k-1));
            if(index > i){
                if(dfs(map , stones , index , k-1 , dp)) return dp[i][k]= true;
            }
        }
        if(map.containsKey(stones[i] + k )){
            int index = map.get(stones[i] + k);
            if(index > i){
                if(dfs(map , stones , index , k , dp)) return dp[i][k] = true;
            }
        }
        if(map.containsKey(stones[i] + (k+1))){
            int index = map.get(stones[i] + (k+1));
            if(index > i){
                if(dfs(map , stones , index , k+1 , dp)) return dp[i][k] = true;
            }
        }
        return dp[i][k] = false;
    }
    public boolean canCross(int[] stones) {
        if(stones.length == 1) return true;
        if(stones[1] != 1) return false;
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < stones.length ; i++) map.put(stones[i] , i);
        Boolean[][] dp = new Boolean[stones.length][stones.length+1];
        return dfs(map , stones , 0 , 0 , dp);
    }
}