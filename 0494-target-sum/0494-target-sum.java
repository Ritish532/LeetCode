class Solution {
    public int find(int i , int s , int target , int[] nums){
        if(i == nums.length){
            if(s == target) return 1;
            else return 0;
        }
        int add = find(i+1 , s+nums[i] , target , nums);
        int sub = find(i+1 , s-nums[i] , target , nums);
        return add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length , sum = 0;
        for(int l : nums) sum += l;
        int[][] dp = new int[n][2*sum + 1];
        return find(0 , 0 , target , nums);
    }
}