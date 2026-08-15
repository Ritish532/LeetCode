class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n < 3) return 0;
        int count = 0 , len = 2;
        for(int i = 2; i < n ; i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                len++;
            }
            else len = 2;
            if(len >= 3) count += len-2;
        }
        return count;
    }
}