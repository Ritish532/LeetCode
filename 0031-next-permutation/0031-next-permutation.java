class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i >= 0 && nums[i] >= nums[i+1]) i--;
        int j = nums.length-1;
        int temp;
        if(i >= 0){
            while(j > 0 && nums[j] <= nums[i]) j--;
        
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        int left = i+1;
        int right = nums.length-1;
        while(left < right){
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            right--;
            left++;
        }
    }
}