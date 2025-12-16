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
        int[] ans = new int[n];
        for(int i = 0 ; i <n ; i++) ans[i] = 0;
        int i = 0 , k = 0;
        while(i < n){
            if(nums[i] > 0) ans[k++] = nums[i];
            i++;
        }
        return ans;
    }
}