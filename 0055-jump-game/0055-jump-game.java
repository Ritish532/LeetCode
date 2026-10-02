class Solution {
    public boolean canJump(int[] nums) {
        int i = 0 , n = nums.length;
        if(n == 1) return true;
        while(i < n-1){
            int k = nums[i];
            if(k == 0) return false;
            if(i+k >= n-1) return true;
            int maxi = 0 , max = -1 , j = 1;
            while(k > 0){
                if(j+i == n-1) return true;
                if(max <= i+ j + nums[i+j]){
                    max = i + j + nums[i+j];
                    maxi = i+j;
                }
                k--;
                j++;
            }
            i = maxi;
        }
        return false;
    }
}