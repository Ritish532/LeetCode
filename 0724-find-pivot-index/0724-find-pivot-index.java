class Solution {
    public int pivotIndex(int[] nums) {
        for(int i = 1 ; i < nums.length ; i++) nums[i] += nums[i-1];
        for(int j = 0 ; j < nums.length ; j++){
            int Lsum , Rsum;
            if(j == 0) Lsum = 0;
            else Lsum = nums[j-1];
            if(j == nums.length-1) Rsum = 0;
            else Rsum = nums[nums.length-1] - nums[j];
            
            if(Lsum == Rsum) return j;
        }
        return -1;
    }
}