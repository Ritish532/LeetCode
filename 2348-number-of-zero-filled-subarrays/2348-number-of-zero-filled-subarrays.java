class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length ; long m = 0;
        int k = 0 ;int i = 0 ; 
        while(i < n){
            while(i < n && nums[i] != 0) i++;
            k = i;
            while(i < n && nums[i] == 0){
                i++;
            }
            long dist = i - k;
            m += (((dist+1)*(dist)) / 2);
            
        }

        return m;
    }
}