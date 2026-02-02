class Solution {
    public int sum (int[] nums){
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++) sum += nums[i];
        return sum;
    }
    public int addedInteger(int[] nums1, int[] nums2) {
        int sum2 = sum(nums2);
        int sum1 = sum(nums1);
        int len = nums1.length;
        return (sum2-sum1)/len;
    }
}