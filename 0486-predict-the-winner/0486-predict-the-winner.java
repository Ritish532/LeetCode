class Solution {
    public int rec(int[] nums , int i , int j){
        if(i == j) return nums[i];
        int start = nums[i] - rec(nums , i+1 , j);
        int end = nums[j] - rec(nums , i , j-1);
        return Math.max(start , end);
    }
    public boolean predictTheWinner(int[] nums) {
        return rec(nums , 0 , nums.length-1) >= 0;
    }
}