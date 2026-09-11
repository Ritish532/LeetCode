class Solution {
    public int helper(int n , int[][] nums , int[][] dp , int i , int j){
        if(nums[i][j] == 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int up = up(i-1,j,nums);
        int down = down(i+1,j,nums);
        int left = left(i,j-1,nums);
        int right = right(i,j+1,nums);
        return dp[i][j] = 1 + Math.min( up , Math.min( down , Math.min( left , right)));
    }
    public int up(int i , int j , int[][] nums){
        int count = 0;
        while(i >= 0 && nums[i][j] == 1) if(nums[i--][j] == 1) count++;
        return count;
    }
    public int down(int i , int j , int[][] nums){
        int count = 0;
        while(i < nums.length && nums[i][j] == 1) if(nums[i++][j] == 1) count++;
        return count;
    }
    public int left(int i , int j , int[][] nums){
        int count = 0;
        while(j >= 0 && nums[i][j] == 1) if(nums[i][j--] == 1) count++;
        return count;
    }
    public int right(int i , int j , int[][] nums){
        int count = 0;
        while(j < nums.length && nums[i][j] == 1) if(nums[i][j++] == 1) count++;
        return count;
    }
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        if(n == 1) return 0;
        int[][] arr = new int[n][n];
        for(int[] row : arr) Arrays.fill(row , 1);
        for(int[] row : mines) arr[row[0]][row[1]] = 0;

        int[][] dp = new int[n][n];
        for(int[] row : dp) Arrays.fill(row,-1);
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                ans = Math.max(ans , helper(n , arr , dp , i , j));
            }
        }
        return ans;
    }
}