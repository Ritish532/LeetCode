class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for(int i = 0 ; i < n-1 ; i++){
            int j = i+1;
            if(nums[i] == nums[j]){
                nums[i]*=2;
                nums[j] = 0;
            }
        }
        int z = 0 , k = 0;
        while(k < n){
            if(nums[k] != 0){
                int temp = nums[k];
                nums[k] = nums[z];
                nums[z] = temp;
                z++;
            }
            k++;
        }
        return nums;
    }
}