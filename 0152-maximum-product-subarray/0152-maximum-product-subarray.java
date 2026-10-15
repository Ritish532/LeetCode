class Solution {
    public int maxProduct(int[] nums) {
        int ans = 0 , n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n];
        Arrays.fill(dp , -1);
        for(int i = 0 ; i < n ; i++){
            if(dp[i] != -1) continue;
            int product = 1;
            for(int j = i ; j < n ; j++){
                product *= nums[j];
                ans = Math.max(ans , product);
                dp[i] = ans;
            }
        }
        return ans;
    }
}