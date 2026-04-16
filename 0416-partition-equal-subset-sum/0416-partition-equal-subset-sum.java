class Solution {
    public boolean Can(int i , int[] arr , int[][] dp , int target){
        if(i >= arr.length){
            if(target == 0) return true;
            else return false;
        }
        if(dp[i][target] != -1) return (dp[i][target] == 1);
        boolean ans = false;
        boolean skip = Can(i+1 , arr , dp , target);
        if(target-arr[i] < 0 ) ans = skip; 
        else {
            boolean pick = Can(i+1 , arr , dp , target-arr[i]);
            ans = pick || skip;
        }
        dp[i][target] = (ans)? 1 : 0;
        return ans;

    }
    public boolean canPartition(int[] arr) {
        int n = arr.length ; 
        int sum = 0;
        for(int ele : arr) sum += ele;
        if( sum % 2 != 0) return false;
        int target = sum/2;
        int[][] dp = new int[n][target+1];
        for(int[] row : dp) Arrays.fill(row , -1);
        return Can(0 , arr , dp , target);
    }
}