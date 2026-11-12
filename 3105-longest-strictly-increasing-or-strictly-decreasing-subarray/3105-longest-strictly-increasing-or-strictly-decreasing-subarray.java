class Solution {
    public int maxInc;
    public int maxDec;
    public void helper(int i , int prev , int inc , int dec , int[] nums){
        maxInc = Integer.max(maxInc , inc);
        maxDec = Integer.max(maxDec , dec);
        if(i == nums.length) return;
        if(nums[i] > prev) helper(i+1 , nums[i] , inc+1 , 1 , nums);
        else if(nums[i] == prev) helper(i+1 , nums[i] , 1 , 1 , nums);
        else helper(i+1 , nums[i] , 1 , dec+1 , nums);
    }
    public int longestMonotonicSubarray(int[] nums) {
        maxInc = 1;
        maxDec = 1;
        helper(1 , nums[0] , 1 , 1 , nums);
        return Integer.max(maxInc , maxDec);
    }
}