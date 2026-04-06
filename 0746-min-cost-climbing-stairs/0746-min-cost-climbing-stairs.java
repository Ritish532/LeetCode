// //TABULATION
// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;
//         dp = new int[n];
//         Arrays.fill(dp,-1);
//         return Math.min(minCost(cost , n-1) , minCost(cost , n-2));
//     }
// }

// MEMOIZATION
class Solution {
    public int[] dp;
    public int minCost(int[] cost , int idx) {
        if(idx <= 1) return cost[idx];
        // if(dp[idx] != -1) return dp[idx];
        return cost[idx] + Math.min(minCost(cost,idx-1), minCost(cost,idx-2));
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        return Math.min(minCost(cost , n-1) , minCost(cost , n-2));
    }
}