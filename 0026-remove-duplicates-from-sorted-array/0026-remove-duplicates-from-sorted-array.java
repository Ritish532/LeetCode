class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        int k = 0 , i = 0 , j = 0;
        while(j < n){
            int count = 1;
            j = j+1;
            while(j < n && nums[i] == nums[j]){
                count += 1;
                j++;
            }
            nums[k] = nums[i];
            k++;
            
            i = j;
        }
        return k;
    }
}